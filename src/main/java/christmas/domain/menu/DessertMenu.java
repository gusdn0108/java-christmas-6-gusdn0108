package christmas.domain.menu;

public enum DessertMenu {
    CHOCOLATECAKE("초코케이크", 15000),
    ICECREAM("아이스크림", 5000);

    private final String name;
    private final int price;


    DessertMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
