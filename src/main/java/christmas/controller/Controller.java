package christmas.controller;

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
        OrderMenu orderMenu = orderMenu();
        int totalPrice = orderMenu.totalPrice();
        OutputView.printTotalPrice(totalPrice);
        Sale salePrice = Sale.totalDaySalePrice(visitDay.getDay());
        OutputView.printPromotionPrice();
        OutputView.printDaySalePrice(salePrice.getSale());


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
        int day = visitDay.getDay();
        int discount = 0;
        if (day == 3 || day == 10 || day == 17 || day == 24 || day == 25 || day == 31) {
            discount = 1000;
            OutputView.printSpecialDay(discount);
        }

        return discount;
    }

    private int weekEndPrice(VisitDay visitDay, OrderMenu orderMenu) {
        int weekdaySalePrice = 0;
        if (Objects.equals(visitDay.getDayType(visitDay.getDay()), "주말")) {
            weekdaySalePrice = weekendSale(visitDay, orderMenu);
            if(weekdaySalePrice != 0 ){
                OutputView.printSaleWeekend(weekdaySalePrice);
            }
        }

        return weekdaySalePrice;
    }



    private int weekDayPrice(VisitDay visitDay, OrderMenu orderMenu) {
        int weekdaySalePrice = 0;
        if (Objects.equals(visitDay.getDayType(visitDay.getDay()), "평일")) {
            weekdaySalePrice = weekdaySale(visitDay, orderMenu);
            OutputView.printSaleWeekDay(weekdaySalePrice);
        }

        return weekdaySalePrice;
    }

    private int weekendSale(VisitDay visitDay, OrderMenu orderMenu) {
        Map<Menu, Integer> orderMap = orderMenu.getOrderMap();
        int mainDiscount = 2023;
        int discountPrice = 0;
        if(Objects.equals(visitDay.getDayType(visitDay.getDay()), "주말")){
            for (Entry<Menu, Integer> entry : orderMap.entrySet()) {
                Menu menu = entry.getKey();
                int count = entry.getValue();
                if(menu.getMenuCategory() == MenuCategory.Main){
                    discountPrice += mainDiscount * count;
                }
            }
        }
        return discountPrice;
    }

    private int weekdaySale(VisitDay visitDay, OrderMenu orderMenu) {
        int dessertDiscount = 2023;
        int discountPrice = 0;
        if(Objects.equals(visitDay.getDayType(visitDay.getDay()), "평일")){
            Map<Menu, Integer> orderMap = orderMenu.getOrderMap();
            for (Entry<Menu, Integer> entry : orderMap.entrySet()) {
                Menu menu = entry.getKey();
                List<Menu> menuCount = new ArrayList<>();
                menuCount.add(menu);
                if(menu.getMenuCategory() == MenuCategory.Dessert){
                    discountPrice += dessertDiscount *  menuCount.size();
                }
            }
        }
        return discountPrice;
    }



    private OrderMenu orderMenu() {
        OutputView.printOrderMenuAndCounted();
        String userInput1 = InputView.userInput();
        OrderMenu orderMap = foodOrder(userInput1);
        OutputView.printOrderMenuAndCounted(orderMap.getOrderMap());
        return orderMap;
    }

    private static VisitDay visitDay() {
        OutputView.printEventStart();
        OutputView.printExpectationVisited();
        String userInput = InputView.userInput();
        return new VisitDay(InputView.parsedInputNumber(userInput));
    }

    private OrderMenu foodOrder(String order) {
        Map<Menu, Integer> orderMap = new HashMap<>();
        for (String item : order.split(",")) {
            String[] parts = item.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("매뉴와 갯수를 입력해주세요");
            }
            Menu menu = Menu.findByName(parts[0].trim());
            int count = Integer.parseInt(parts[1].trim());

            if(orderMap.containsKey(menu)){
                throw new IllegalArgumentException("같은 매뉴를 입력했습니다");
            }
            orderMap.put(menu,count);
        }
        return new OrderMenu(orderMap);
    }



}
