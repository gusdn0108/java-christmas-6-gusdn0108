package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BadgeTest {
    @DisplayName("총 할인 금액 이상시 금액 마다 배지 부가 가능한지 확인하기")
    @Test
    void testAwardBadge() {
        Badge badge = Badge.awardBadge(5000);
        assertEquals(Badge.Star, badge);

        Badge badge1 = Badge.awardBadge(10000);
        assertEquals(Badge.Tree, badge1);

        Badge badge2 = Badge.awardBadge(20000);
        assertEquals(Badge.Santa, badge2);
    }

}