package christmas.utils;

public enum ErrorMessage {
    USER_INSERT_NOT_AVAILABLE_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    USER_INSERT_NOT_AVAILABLE_DAY("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_ORDER_ONLY_DRINK("[ERROR] 음료 메뉴만 주문 할 수 없습니다 다시 입력해 주세요"),
    NOT_ORDER_TWENTY_MENU("[ERROR] 주문갯수는 20개 초과 주문할 수 없습니다 다시 입력해 주세요");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}