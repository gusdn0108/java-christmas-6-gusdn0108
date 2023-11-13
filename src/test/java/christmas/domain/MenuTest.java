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
}