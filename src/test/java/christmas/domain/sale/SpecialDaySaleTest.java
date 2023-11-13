package christmas.domain.sale;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import christmas.domain.OrderMenu;
import christmas.domain.VisitDay;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDaySaleTest {
    @DisplayName("별이 붙은 날에 특별 할인이 적용 되는지 확인")
    @Test
    void testDiscount() {
        Sale specialDaySale = new SpecialDaySale();
        VisitDay specialDay = new VisitDay(3);

        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        int discount = specialDaySale.discount(specialDay, orderMenu);

        assertEquals(1000, discount);
    }

}