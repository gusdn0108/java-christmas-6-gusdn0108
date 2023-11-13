package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import java.util.List;

public class Sales {
    private final List<Sale> sales;

    public Sales(List<Sale> sales) {
        this.sales = sales;
    }

    public int discountAll(VisitDay visitDay, OrderMenu orderMenu) {
        if (orderMenu.totalPrice() < 10000) {
            return 0;
        }
        int totalDisCount = 0;
        for (Sale sale : sales) {
            totalDisCount += sale.discount(visitDay, orderMenu);
        }
        return totalDisCount;
    }

    public List<Sale> getSales() {
        return sales;
    }
}
