package christmas.domain.menu;

public enum MainMenu {
    TBONESTAKE("티본스테이크", 55000),
    BBQRIBS("바비큐립",54000),
    SEAFOODFASTA("해산물파스타",35000),
    CHRISMASFASTA("크리스마스파스타",25000);

    private final String name;
    private final int price;


    MainMenu(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
