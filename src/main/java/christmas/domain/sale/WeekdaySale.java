package christmas.domain.sale;


import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class WeekdaySale implements SaleInterface{
    public int discount(VisitDay visitDay, OrderMenu orderMenu) {
        int weekdaySalePrice = 0;
        if (visitDay.isWeekday()) {
            weekdaySalePrice = weekdaySale(visitDay, orderMenu);
            OutputView.printSaleWeekend(weekdaySalePrice);
        }

        return weekdaySalePrice;
    }
    public int weekdaySale(VisitDay visitDay, OrderMenu orderMenu) {
        int discountPrice = 0;
        if (visitDay.isWeekday()) {
            int mainDiscount = 2023;
            for (Menu categroyMenu : orderMenu.getMenuInCategory(MenuCategory.Dessert)) {
                int count = orderMenu.getOrderCount(categroyMenu);
                discountPrice += mainDiscount * count;
            }

        }
        return discountPrice;
    }

}
