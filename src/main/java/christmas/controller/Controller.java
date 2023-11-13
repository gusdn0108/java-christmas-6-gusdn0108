package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.Sale;
import christmas.domain.VisitDay;
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
        VisitDay visitDay = visitDay();
        OrderMenu orderMenu = InputView.orderMenu();
        int totalPrice = orderMenu.totalPrice();
        OutputView.printTotalPrice(totalPrice);
        Sale salePrice = Sale.totalDaySalePrice(visitDay.getDay());
        OutputView.printPromotionPrice();
        OutputView.printDaySalePrice(salePrice.getSale());
        int weekdayPrice = weekDayPrice(visitDay, orderMenu);
        int weekEndPrice = weekEndPrice(visitDay, orderMenu);
        int specialDayPrice = specialDayPrice(visitDay);
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


    private int specialDayPrice(VisitDay visitDay) {
        List<Integer> specialDays = List.of(3, 10, 17, 24, 25, 31);
        if (visitDay.isContained(specialDays)) {
            final int discount = 1000;
            OutputView.printSpecialDay(discount);
        }
        return 0;
    }

    private int weekEndPrice(VisitDay visitDay, OrderMenu orderMenu) {
        int weekdaySalePrice = 0;
        if (visitDay.isWeekend()) {
            weekdaySalePrice = weekendSale(visitDay, orderMenu);
            if (weekdaySalePrice != 0) {
                OutputView.printSaleWeekend(weekdaySalePrice);
            }
        }

        return weekdaySalePrice;
    }


    private int weekDayPrice(VisitDay visitDay, OrderMenu orderMenu) {
        int weekdaySalePrice = 0;
        if (visitDay.isWeekday()) {
            weekdaySalePrice = weekdaySale(visitDay, orderMenu);
            OutputView.printSaleWeekDay(weekdaySalePrice);
        }

        return weekdaySalePrice;
    }

    private int weekendSale(VisitDay visitDay, OrderMenu orderMenu) {
        Map<Menu, Integer> orderMap = orderMenu.getOrderMap();
        int mainDiscount = 2023;
        int discountPrice = 0;
        if (visitDay.isWeekend()) {
            for (Entry<Menu, Integer> entry : orderMap.entrySet()) {
                Menu menu = entry.getKey();
                int count = entry.getValue();
                if (menu.getMenuCategory() == MenuCategory.Main) {
                    discountPrice += mainDiscount * count;
                }
            }
        }
        return discountPrice;
    }

    private int weekdaySale(VisitDay visitDay, OrderMenu orderMenu) {
        int dessertDiscount = 2023;
        int discountPrice = 0;
        if (visitDay.isWeekday()) {
            for(Menu categroyMenu :orderMenu.getMenuInCategory(MenuCategory.Dessert)){
                int count = orderMenu.getOrderCount(categroyMenu);
                discountPrice += dessertDiscount * count;
            }

        }
        return discountPrice;
    }



    private static VisitDay visitDay() {
        try {
            OutputView.printEventStart();
            OutputView.printExpectationVisited();
            String userInput = InputView.userInput();
            return new VisitDay(InputView.parsedInputNumber(userInput));
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return visitDay();
        }
    }



}
