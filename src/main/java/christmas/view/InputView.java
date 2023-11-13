package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
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
        OutputView.printOrderMenuAndCounted();
        String userInput1 = InputView.userInput();
        OutputView.printShowEvent();
        OrderMenu orderMap = foodOrder(userInput1);
        OutputView.printOrderMenuAndCounted(orderMap.getOrderMap());
        return orderMap;
    }

    public static OrderMenu foodOrder(String order) {
        try {
            return getOrderMenu(order);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.USER_INSERT_NOT_AVAILABLE_MENU.getMessage());
            return foodOrder(InputView.userInput());
        }
    }

    private static OrderMenu getOrderMenu(String order) {
        Map<Menu, Integer> orderMap = new HashMap<>();
        for (String item : order.split(",")) {
            String[] parts = item.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException(ErrorMessage.USER_INSERT_MENU_AND_COUNT.getMessage());
            }
            Menu menu = getMenu(parts, orderMap);
            int count = getCount(parts);
            orderMap.put(menu, count);
        }
        return new OrderMenu(orderMap);
    }

    private static int getCount(String[] parts) {
        return Integer.parseInt(parts[1].trim());
    }

    private static Menu getMenu(String[] parts, Map<Menu, Integer> orderMap) {
        Menu menu = Menu.findByName(parts[0].trim());
        if (orderMap.containsKey(menu)) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_DUPLICATION_MENU.getMessage());
        }
        return menu;
    }

}
