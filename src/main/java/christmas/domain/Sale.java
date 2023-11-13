package christmas.domain;

public class Sale {

    private final int sale;

    public Sale(int sale) {
        this.sale = sale;
    }

    public static Sale totalDaySalePrice(int visitDay) {
        int salePrice = 1000;
        int totalSalePrice = salePrice+((visitDay-1) * 100);
        return new Sale(totalSalePrice);
    }

    public int getSale() {
        return sale;
    }
}
