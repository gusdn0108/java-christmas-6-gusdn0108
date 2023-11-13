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
