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

    @DisplayName("주문숫자가 1 미만일 경우 예외처리")
    @Test
    void testInvalidOrderMap() {
        Map<Menu, Integer> invalidOrderMap = new HashMap<>();
        invalidOrderMap.put(Menu.REDWAIN, -1);

        assertThrows(IllegalArgumentException.class, () -> new OrderMenu(invalidOrderMap));
    }

    @DisplayName("음료만 주문했을 경우 예외처리가 잘 나오는지 확인 ")
    @Test
    void testOnlyDrinkException() {
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);

        assertThrows(IllegalArgumentException.class, () -> new OrderMenu(orderMap));
    }

    @DisplayName("주문숫자가 20 초과일 경우 예외처리")
    @Test
    void testTwentyOverOrderMap() {
        Map<Menu, Integer> invalidOrderMap = new HashMap<>();
        invalidOrderMap.put(Menu.REDWAIN, 21);

        assertThrows(IllegalArgumentException.class, () -> new OrderMenu(invalidOrderMap));
    }

    @DisplayName("특정 카테고리 의 매뉴 개수 구하는 기능이 잘 잘동되는지 확인하기")
    @Test
    void testGetMenuInCategoryForOrderMenu() {
        Map<Menu, Integer> orderMap = new HashMap<>();
        orderMap.put(Menu.REDWAIN, 2);
        orderMap.put(Menu.CHRISMASFASTA, 1);
        orderMap.put(Menu.ICECREAM, 3);

        OrderMenu orderMenu = new OrderMenu(orderMap);
        assertEquals(1, orderMenu.getMenuInCategory(MenuCategory.Dessert).size());
    }

}