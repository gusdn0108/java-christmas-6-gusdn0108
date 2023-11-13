package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderMenuTest {
    @DisplayName("주문한 매뉴 가격 구하기")
    @Test
    void testTotalPrice() {
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        assertEquals(145000, orderMenu.totalPrice());
    }

    @DisplayName("특정 카테고리 매뉴 찾기")
    @Test
    void testGetMenuInCategory() {
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);
        orderMap.put(Menu.ICECREAM, 3);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        assertEquals(1, orderMenu.getMenuInCategory(MenuCategory.Dessert).size());
    }

    @DisplayName("주문한 매뉴 갯수 찾기")
    @Test
    void testGetOrderCount() {
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        assertEquals(2, orderMenu.getOrderCount(Menu.REDWAIN));
    }
}