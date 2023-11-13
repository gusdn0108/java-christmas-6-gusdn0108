package christmas.domain.sale;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class WeekendDaySale implements SaleInterface {
    public int discount(VisitDay visitDay, OrderMenu orderMenu) {
        int weekendSalePrice = 0;
        if (visitDay.isWeekend()) {
            weekendSalePrice = weekendSale(visitDay, orderMenu);
            OutputView.printSaleWeekend(weekendSalePrice);
        }
        return weekendSalePrice;
    }

    public int weekendSale(VisitDay visitDay, OrderMenu orderMenu) {
        int mainDiscount = 2023;
        int discountPrice = 0;
        if (visitDay.isWeekend()) {
            for(Menu categroyMenu :orderMenu.getMenuInCategory(MenuCategory.Main)){
                int count = orderMenu.getOrderCount(categroyMenu);
                discountPrice += mainDiscount * count;
            }

        }
        return discountPrice;
    }

}
