package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class DdaySale implements Sale {
    public int discount (VisitDay visitDay, OrderMenu orderMenu) {
        if (visitDay.getDay() > 25) {
            return 0;
        }
        int salePrice = 1000;
        salePrice += ((visitDay.getDay() - 1) * 100);
        OutputView.printDaySalePrice(salePrice);
        return salePrice;
    }
}
