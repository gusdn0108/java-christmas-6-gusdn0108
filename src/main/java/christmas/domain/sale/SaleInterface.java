package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;

public interface SaleInterface {
    int discount(VisitDay day, OrderMenu orderMenu);
}
