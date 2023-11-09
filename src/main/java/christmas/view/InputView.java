package christmas.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String userInput(){
        return Console.readLine();
    }

    public static int parsedInputNumber(String input){
        return Integer.parseInt(input);
    }
}
