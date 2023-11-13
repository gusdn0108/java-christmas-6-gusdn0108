package christmas.domain;

public enum Menu {
    MUSHROOMCREAMSOUP("양송이수프",6000, MenuCategory.Appetizer),
    TAPAS("타파스",5500,MenuCategory.Appetizer),
    CAESARSALAD("시저샐러드",8000, MenuCategory.Appetizer),
    CHOCOLATECAKE("초코케이크",15000, MenuCategory.Dessert),
    ICECREAM("아이스크림",5000, MenuCategory.Dessert),
    ZEROCOKE("제로콜라",3000, MenuCategory.Drink),
    REDWAIN("레드와인",60000, MenuCategory.Drink),
    CHAMPAGNE("샴페인",250000, MenuCategory.Drink),
    TBONESTAKE("티본스테이크",55000, MenuCategory.Main),
    BBQRIBS("바비큐립",54000, MenuCategory.Main),
    SEAFOODFASTA("해산물파스타",35000, MenuCategory.Main),
    CHRISMASFASTA("크리스마스파스타",25000, MenuCategory.Main);

    private final String name;
    private final int price;
    private final MenuCategory menuCategory;

    Menu(String name, int price, MenuCategory menuCategory) {
        this.name = name;
        this.price = price;
        this.menuCategory = menuCategory;
    }

    public static Menu findByName(String menuName) {
        for(Menu menu : values()){
            if(menu.getName().equals(menuName)){
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuCategory getMenuCategory() {
        return menuCategory;
    }
}
