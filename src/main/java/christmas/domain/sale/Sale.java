package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;

public interface Sale {
    int discount(VisitDay day, OrderMenu orderMenu);
}
