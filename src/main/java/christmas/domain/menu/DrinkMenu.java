package christmas.domain.menu;

public enum DrinkMenu {

    ZERO_COKE("제로콜라",3000);

    private final String name;
    private final int price;


    DrinkMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
