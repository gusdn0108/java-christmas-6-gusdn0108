package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.domain.sale.DdaySale;
import christmas.domain.sale.Sales;
import christmas.domain.sale.SpecialDaySale;
import christmas.domain.sale.WeekdaySale;
import christmas.domain.sale.WeekendDaySale;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;


public class Controller {
    private static final int GIVE_AWAY_CONDITIONS = 120000;
    private static final int EVENT_NOTING_CONDITION = 10000;
    private static final int BADGE_PRICE_CONDITION = 5000;

    public void run() {
        VisitDay visitDay = InputView.visitDay();
        OrderMenu orderMenu = InputView.orderMenu();
        int totalPrice = orderMenu.totalPrice();

        if (totalPrice > GIVE_AWAY_CONDITIONS) {
            OutputView.promotionMenu();
            OutputView.printGiveAwayChampagne();
        }

        OutputView.printBeforeSaleTotalPrice(totalPrice);

        if (totalPrice < GIVE_AWAY_CONDITIONS) {
            OutputView.promotionMenu();
            OutputView.printNoting();
        }

        OutputView.printBenefitDetails();
        int discountPrice = discountPrice(visitDay, orderMenu);

        if (totalPrice < EVENT_NOTING_CONDITION) {
            OutputView.printNoting();
        }
        int promotionPrice = promotionPrice(totalPrice);
        OutputView.printTotalSalePrice(discountPrice + promotionPrice);

        int amountTotalPrice = totalPrice - discountPrice;
        OutputView.printAmountOfPayment(amountTotalPrice);

        Badge badge = Badge.awardBadge(amountTotalPrice);
        dependsGiveBadge(discountPrice, promotionPrice, badge);
    }

    private static void dependsGiveBadge(int discountPrice, int promotionPrice, Badge badge) {
        if (discountPrice + promotionPrice < BADGE_PRICE_CONDITION) {
            OutputView.printPromotionBadgeEvent();
            OutputView.printNoting();
        }

        if (discountPrice + promotionPrice > BADGE_PRICE_CONDITION) {
            OutputView.printEventBadge(badge);
        }
    }

    private int promotionPrice(int totalPrice) {
        int gitEventDiscount = 0;
        if (totalPrice > GIVE_AWAY_CONDITIONS) {
            gitEventDiscount = 25000;
            OutputView.printGiveAwayEvent(gitEventDiscount);
        }
        return gitEventDiscount;
    }

    private int discountPrice(VisitDay visitDay, OrderMenu orderMenu) {
        Sales sales = new Sales(List.of(new DdaySale(), new WeekendDaySale(), new WeekdaySale(), new SpecialDaySale()));
        return sales.discountAll(visitDay, orderMenu);
    }

}


