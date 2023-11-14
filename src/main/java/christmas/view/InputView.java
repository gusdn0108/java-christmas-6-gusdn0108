package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.utils.ErrorMessage;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public static String userInput() {
        return Console.readLine();
    }

    public static int parsedInputNumber(String input) {
        return Integer.parseInt(input);
    }

    public static VisitDay visitDay() {
        try {
            OutputView.printEventStart();
            OutputView.printExpectationVisited();
            String userInput = InputView.userInput();
            return new VisitDay(InputView.parsedInputNumber(userInput));
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.USER_INSERT_NOT_AVAILABLE_DAY.getMessage());
            return visitDay();
        }
    }

    public static OrderMenu orderMenu() {
        try {
            OutputView.printOrderMenuAndCounted();
            String order = InputView.userInput();
            OrderMenu orderMap = foodOrder(order);
            OutputView.printShowEvent();
            OutputView.printOrderMenuAndCounted(orderMap.getOrderMap());
            return orderMap;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return orderMenu();
        }

    }

    public static OrderMenu foodOrder(String order) {
        Map<Menu, Integer> orderMap = new HashMap<>();
        for (String item : order.split(",")) {
            String[] parts = item.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_AVAILABLE_MENU.getMessage());
            }
            Menu menu = Menu.findByName(parts[0].trim());
            if (orderMap.containsKey(menu)) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_AVAILABLE_MENU.getMessage());
            }
            try {
                int count = Integer.parseInt(parts[1].trim());
                orderMap.put(menu, count);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_AVAILABLE_MENU.getMessage());
            }
        }
        return new OrderMenu(orderMap);
    }

}



