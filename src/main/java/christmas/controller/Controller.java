package christmas.controller;

import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    public void run() {
        String userInput = visitDay();
        orderMenu();
    }

    private OrderMenu orderMenu() {
        OutputView.printOrderMenuAndCounted();
        String userInput1 = InputView.userInput();
        OrderMenu orderMap = foodOrder(userInput1);
        OutputView.printOrderMenuAndCounted(orderMap.getOrderMap());
        return orderMap;
    }

    private static String visitDay() {
        OutputView.printEventStart();
        OutputView.printExpectationVisited();
        return InputView.userInput();
    }

    



}
