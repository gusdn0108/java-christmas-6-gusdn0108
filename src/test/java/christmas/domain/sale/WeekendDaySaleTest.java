package christmas.domain.sale;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDaySaleTest {
    @DisplayName("주말 할인 적용 확인")
    @Test
    void testWeekendSale() {
        Sale weekendDaySale = new WeekendDaySale();
        VisitDay weekendDay = new VisitDay(1);

        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);
        orderMap.put(Menu.TBONESTAKE, 2);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        int discount = weekendDaySale.discount(weekendDay, orderMenu);

        assertEquals(6069, discount);
    }
}