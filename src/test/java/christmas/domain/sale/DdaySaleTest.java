package christmas.domain.sale;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DdaySaleTest {
    @DisplayName("디데이 할인이 적용 되는지 확인 ")
    @Test
    void testDiscount() {
        Sale ddaySale = new DdaySale();
        VisitDay normalDay = new VisitDay(28);
        VisitDay eventDay = new VisitDay(25);

        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        int discount = ddaySale.discount(normalDay, orderMenu);
        int discount2 = ddaySale.discount(eventDay, orderMenu);

        assertEquals(0, discount);
        assertEquals(3400, discount2);
    }
}