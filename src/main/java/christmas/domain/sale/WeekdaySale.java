package christmas.domain.sale;


import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;

public class WeekdaySale {
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
