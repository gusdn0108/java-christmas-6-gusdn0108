package christmas.view;

import christmas.domain.Menu;
import java.util.Map;

public class OutputView {
    public static void printEventStart(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printExpectationVisited(){
        System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
    }

    public static void printOrderMenuAndCounted(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
    }

    public static void printDaySalePrice(int salePrice) {
        System.out.println("크리스마스 디데이 할인: "+"-"+salePrice+"원");
    }

    public static void printSaleWeekDay(int weekdaySalePrice) {
        System.out.println("평일 할인: "+"-"+weekdaySalePrice+"원");
    }

    public static void printSaleWeekend(int weekdaySalePrice) {
        System.out.println("주말 할인: "+(-1)*weekdaySalePrice+"원");
    }

    public static void printSpecialDay(int discount) {
        System.out.println("특별 할인: "+"-"+discount+"원 ");
    }


}
