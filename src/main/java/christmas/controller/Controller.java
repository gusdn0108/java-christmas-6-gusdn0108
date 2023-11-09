package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Controller {
    public void run() {
        part1();
    }

    private void part1(){
        OutputView.printEventStart();
        OutputView.printExpectationVisited();
        String userInput = InputView.userInput();
        InputView.parsedInputNumber(userInput);

    }
}
