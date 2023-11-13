package christmas.domain;

public enum Badge {
    Star(5000),
    Tree(10000),
    Stanta(200000),
    Nothing(0);

    private final int minimumPrice;

    Badge(int minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    public int getMinimumPrice() {
        return minimumPrice;
    }
}
