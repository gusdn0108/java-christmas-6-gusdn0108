package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import java.util.HashMap;
import java.util.Map;

public class InputView {

    public static String userInput(){
        return Console.readLine();
    }

    public static int parsedInputNumber(String input){
        return Integer.parseInt(input);
    }

    public static VisitDay visitDay() {
        try {
            OutputView.printEventStart();
            OutputView.printExpectationVisited();
            String userInput = InputView.userInput();
            return new VisitDay(InputView.parsedInputNumber(userInput));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
            return visitDay();
        }
    }
    public static OrderMenu orderMenu() {
        OutputView.printOrderMenuAndCounted();
        String userInput1 = InputView.userInput();
        OrderMenu orderMap = foodOrder(userInput1);
        OutputView.printOrderMenuAndCounted(orderMap.getOrderMap());
        return orderMap;
    }

    public static OrderMenu foodOrder(String order) {
        Map<Menu, Integer> orderMap = new HashMap<>();
        for (String item : order.split(",")) {
            String[] parts = item.split("-");
            if (parts.length != 2) {
                throw new IllegalArgumentException("매뉴와 갯수를 입력해주세요");
            }
            Menu menu = Menu.findByName(parts[0].trim());
            int count = Integer.parseInt(parts[1].trim());

            if (orderMap.containsKey(menu)) {
                throw new IllegalArgumentException("같은 매뉴를 입력했습니다");
            }
            orderMap.put(menu, count);
        }
        return new OrderMenu(orderMap);
    }


}
