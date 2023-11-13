package christmas.utils;

public enum ErrorMessage {
    USER_INSERT_NOT_AVAILABLE_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    USER_INSERT_NOT_AVAILABLE_DAY("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    USER_INSERT_MENU_AND_COUNT("[ERROR] 매뉴와 갯수를 입력해주세요"),
    USER_INSERT_DUPLICATION_MENU("[ERROR] 같은 매뉴를 입력했습니다 "),
    NOT_ORDER_ONLY_DRINK("[ERROR] 음료 메뉴만 주문 할 수 없습니다"),
    NOT_ORDER_TWENTY_MENU("[ERROR] 20개 초과 주문할수없습니다"),
    INSERT_DAY_RANGE_ERROR("[ERROR] 날짜는 1-31 까지만 입력 가능합니다");



    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}