package christmas.domain.sale;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekdaySaleTest {
    @DisplayName("평일 할인이 적용 되는지 확인")
    @Test
    void testWeekdaySale() {
        Sale weekdaySale = new WeekdaySale();
        VisitDay weekday = new VisitDay(3);

        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);
        orderMap.put(Menu.CHOCOLATECAKE, 2);
        orderMap.put(Menu.ICECREAM, 1);


        OrderMenu orderMenu = new OrderMenu(orderMap);
        int discount = weekdaySale.discount(weekday, orderMenu);

        assertEquals(6069, discount);
    }

}