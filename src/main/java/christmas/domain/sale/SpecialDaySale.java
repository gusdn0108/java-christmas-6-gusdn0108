package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;
import java.util.List;

public class SpecialDaySale implements Sale {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private static final int SPECIAL_DISCOUNT = 1000;

    public int discount(VisitDay visitDay, OrderMenu orderMenu) {
        if (visitDay.isContained(SPECIAL_DAYS)) {
            int discount = SPECIAL_DISCOUNT;
            OutputView.printSpecialDay(discount);
            return discount;
        }
        return 0;
    }

}
