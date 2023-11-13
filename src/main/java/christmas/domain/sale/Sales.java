package christmas.domain.sale;

import java.util.List;

public class Sales {
    private final List<Sale> sales;

    public Sales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
