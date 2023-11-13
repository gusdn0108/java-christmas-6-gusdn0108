package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.domain.sale.DdaySale;
import christmas.domain.sale.Sale;
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
        OutputView.printTotalPrice(totalPrice);

        OutputView.printPromotionPrice();
        int discountPrice = discountPrice(visitDay, orderMenu);
        int promotionPrice = promotionPrice(totalPrice);
        OutputView.printTotalSalePrice(discountPrice + promotionPrice);

        int amountTotalPrice = totalPrice - discountPrice;
        OutputView.printAmountOfPayment(amountTotalPrice);

        Badge badge = Badge.awardBadge(amountTotalPrice);
        OutputView.printEventBadge(badge);
    }

    private int promotionPrice(int totalPrice) {
        int gitEventDiscount = 0;
        if (totalPrice > 120000) {
            gitEventDiscount = 25000;
            System.out.println("증정 이벤트: " + "-" + gitEventDiscount + "원");
        }
        return gitEventDiscount;
    }

    private int discountPrice(VisitDay visitDay, OrderMenu orderMenu) {

        List<Sale> sales = List.of(new DdaySale(),new WeekendDaySale(),new WeekdaySale(),new SpecialDaySale());
        
        int totalDisCount = 0;
        for (Sale sale : sales) {
            totalDisCount += sale.discount(visitDay,orderMenu);
        }

        return totalDisCount;
    }


}


