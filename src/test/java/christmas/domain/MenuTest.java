package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @DisplayName("매뉴 찾기 테스트")
    @Test
    void testFindByName() {
        Menu foundMenu = Menu.findByName("시저샐러드");
        assertEquals(Menu.CAESARSALAD, foundMenu);
    }

    @DisplayName("매뉴에 없는 음식을 주문 했을때 예외처리가 잘되는지 확인")
    @Test
    void testInvalidMenuName() {
        assertThrows(IllegalArgumentException.class, () -> Menu.findByName("케잌"));
    }

    @DisplayName("매뉴 카테고리를 구분하는 메소드 기능이 잘 작동되는지 확인")
    @Test
    void testMenuCategory() {
        assertTrue(Menu.MUSHROOMCREAMSOUP.isCategory(MenuCategory.Appetizer));
        assertFalse(Menu.REDWAIN.isCategory(MenuCategory.Dessert));
    }

}