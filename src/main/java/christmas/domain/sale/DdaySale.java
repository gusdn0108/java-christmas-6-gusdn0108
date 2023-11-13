package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class DdaySale implements Sale {
    private static final int LAST_EVENT_DAY = 25;

    public int discount(VisitDay visitDay, OrderMenu orderMenu) {
        if (visitDay.getDay() > LAST_EVENT_DAY) {
            return 0;
        }
        int salePrice = 1000;
        salePrice += ((visitDay.getDay() - 1) * 100);
        OutputView.printDaySalePrice(salePrice);
        return salePrice;
    }
}
