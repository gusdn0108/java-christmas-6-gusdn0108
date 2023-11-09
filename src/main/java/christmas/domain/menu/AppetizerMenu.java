package christmas.domain.menu;

public enum AppetizerMenu {
    MUSHROOMCREAMSOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESARSALAD("시저샐러드",8000);

    private final String name;
    private final int price;


    AppetizerMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

