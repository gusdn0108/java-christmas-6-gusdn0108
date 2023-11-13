package christmas.view;

import christmas.domain.Badge;
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

    public static void printShowEvent(){
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printOrderMenuAndCounted(Map<Menu, Integer> orderMap) {
        System.out.println("\n<주문 메뉴>");
        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            Menu menu = entry.getKey();
            int count = entry.getValue();
            System.out.println(menu.getName()+" "+ count + "개");
        }
    }

    public static void printBeforeSaleTotalPrice(int totalprice){
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(totalprice+"원");
    }

    public static void printBenefitDetails() {
        System.out.println("\n<혜택 내역>");
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

    public static void printTotalSalePrice(int totalSalePrice) {
        System.out.println("\n<총혜택 금액>");
        System.out.println((-1)*totalSalePrice+"원");
    }

    public static void printAmountOfPayment(int amountTotalPrice) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(amountTotalPrice+"원");
    }

    public static void printPromotionBadgeEvent(){
        System.out.println("\n<12월 이벤트 배지>");
    }
    public static  void printEventBadge(Badge badge){
        printPromotionBadgeEvent();
        if(badge == Badge.Nothing){
            System.out.println("없음");
        }
        if(badge == Badge.Star){
            System.out.println("별");
        }
        if(badge == Badge.Tree){
            System.out.println("나무");
        }
        if(badge == Badge.Stanta){
            System.out.println("산타");
        }
    }

    public static void printNoting() {
        System.out.println("없음");
    }

    public static void promotionMenu(){
        System.out.println("\n<증정 메뉴>");
    }




}
