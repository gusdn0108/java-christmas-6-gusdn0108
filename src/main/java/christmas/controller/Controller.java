package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.Sale;
import christmas.domain.VisitDay;
import christmas.domain.sale.SpecialDaySale;
import christmas.domain.sale.WeekdaySale;
import christmas.domain.sale.WeekendDaySale;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Controller {
    public void run() {
        VisitDay visitDay = InputView.visitDay();
        OrderMenu orderMenu = InputView.orderMenu();
        int totalPrice = orderMenu.totalPrice();
        OutputView.printTotalPrice(totalPrice);
        Sale salePrice = Sale.totalDaySalePrice(visitDay.getDay());
        OutputView.printPromotionPrice();
        OutputView.printDaySalePrice(salePrice.getSale());


        int weekdayPrice = new WeekdaySale().discount(visitDay,orderMenu);
        int weekEndPrice = new WeekendDaySale().discount(visitDay,orderMenu);
        int specialDayPrice = new SpecialDaySale().discount(visitDay,orderMenu);
        int promotionPrice = promotionPrice(totalPrice);


        int totalSalePrice = weekdayPrice + weekEndPrice + specialDayPrice + promotionPrice + salePrice.getSale();
        OutputView.printTotalSalePrice(totalSalePrice);
        int amountTotalPrice = totalPrice - totalSalePrice;
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


    }



}
