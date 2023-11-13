package christmas.domain.sale;


import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import christmas.view.OutputView;

public class WeekdaySale implements Sale {

    private static final int DISCOUNT_PRICE = 2023;

    public int discount(VisitDay visitDay, OrderMenu orderMenu) {
        int weekdaySalePrice = 0;
        if (visitDay.isWeekday()) {
            weekdaySalePrice = weekdaySale(visitDay, orderMenu);
            OutputView.printSaleWeekDay(weekdaySalePrice);
        }

        return weekdaySalePrice;
    }

    public int weekdaySale(VisitDay visitDay, OrderMenu orderMenu) {
        int discountPrice = 0;
        if (visitDay.isWeekday()) {
            for (Menu categroyMenu : orderMenu.getMenuInCategory(MenuCategory.Dessert)) {
                int count = orderMenu.getOrderCount(categroyMenu);
                discountPrice += DISCOUNT_PRICE * count;
            }
        }
        return discountPrice;
    }

}
