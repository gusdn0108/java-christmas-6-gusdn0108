package christmas.domain.sale;

import christmas.domain.VisitDay;
import christmas.view.OutputView;
import java.util.List;

public class SpecialDaySale {
    private static final List<Integer> SPECIAL_DAYS = List.of(3, 10, 17, 24, 25, 31);
    private int discount (VisitDay visitDay) {
        if (visitDay.isContained(SPECIAL_DAYS)) {
            final int discount = 1000;
            OutputView.printSpecialDay(discount);
        }
        return 0;
    }

}
