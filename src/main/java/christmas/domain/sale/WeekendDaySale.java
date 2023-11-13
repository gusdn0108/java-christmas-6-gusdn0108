package christmas.domain.sale;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class WeekendDaySale implements Sale {
    private static final int DISCOUNT_PRICE = 2023;
    public int discount(VisitDay visitDay, OrderMenu orderMenu) {
        int weekendSalePrice = 0;
        if (visitDay.isWeekend()) {
            weekendSalePrice = weekendSale(visitDay, orderMenu);
            OutputView.printSaleWeekend(weekendSalePrice);
        }
        return weekendSalePrice;
    }

    public int weekendSale(VisitDay visitDay, OrderMenu orderMenu) {
        int discountPrice = 0;
        if (visitDay.isWeekend()) {
            for(Menu categroyMenu :orderMenu.getMenuInCategory(MenuCategory.Main)){
                int count = orderMenu.getOrderCount(categroyMenu);
                discountPrice += DISCOUNT_PRICE * count;
            }

        }
        return discountPrice;
    }

}
