package christmas.domain.sale;

import christmas.domain.OrderMenu;
import christmas.domain.Sale;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class DdaySale implements SaleInterface{
    public int discount (VisitDay visitDay, OrderMenu orderMenu) {
        if(visitDay.getDay() > 25){
            return 0;
        }
        int salePrice = 1000;
        return salePrice+((visitDay.getDay()-1) * 100);
    }
}
