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
    public void run() {
        VisitDay visitDay = InputView.visitDay();
        OrderMenu orderMenu = InputView.orderMenu();
        int totalPrice = orderMenu.totalPrice();

        if(totalPrice > 120000){
            OutputView.promotionMenu();
            OutputView.printGiveAwayChampagne();
        }

        OutputView.printBeforeSaleTotalPrice(totalPrice);

        if(totalPrice < 120000){
            OutputView.promotionMenu();
            OutputView.printNoting();
        }

        OutputView.printBenefitDetails();
        int discountPrice = discountPrice(visitDay, orderMenu);


        if(totalPrice < 10000){
            OutputView.printNoting();
        }
        int promotionPrice = promotionPrice(totalPrice);
        OutputView.printTotalSalePrice(discountPrice + promotionPrice);

        int amountTotalPrice = totalPrice - discountPrice;
        OutputView.printAmountOfPayment(amountTotalPrice);

        Badge badge = Badge.awardBadge(amountTotalPrice);

        if(discountPrice + promotionPrice < 5000){
            OutputView.printPromotionBadgeEvent();
            OutputView.printNoting();
        }

        if(discountPrice + promotionPrice > 5000){
            OutputView.printEventBadge(badge);
        }
    }

    private int promotionPrice(int totalPrice) {
        int gitEventDiscount = 0;
        if (totalPrice > 120000) {
            gitEventDiscount = 25000;
            OutputView.printGiveAwayEvent(gitEventDiscount);
        }
        return gitEventDiscount;
    }

    private int discountPrice(VisitDay visitDay, OrderMenu orderMenu) {
        Sales sales = new Sales(List.of(new DdaySale(), new SpecialDaySale(), new WeekendDaySale(), new WeekdaySale()));
        return sales.discountAll(visitDay, orderMenu);
    }


}


