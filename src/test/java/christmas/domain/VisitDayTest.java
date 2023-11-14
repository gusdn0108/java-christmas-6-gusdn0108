package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VisitDayTest {
    @DisplayName("지정한 날짜가 주말이 맞는지 확인하기")
    @Test
    void testIsWeekend() {
        VisitDay weekendDay = new VisitDay(1);
        assertTrue(weekendDay.isWeekend());
    }

    @DisplayName("지정한 날짜가 평일이 맞는지 확인하기")
    @Test
    void testIsWeekday() {
        VisitDay weekday = new VisitDay(3);
        assertTrue(weekday.isWeekday());
    }

    @DisplayName("지정한 날짜가 특별한 날이 맞는지 확인하기")
    @Test
    void testIsContained() {
        VisitDay specialDay = new VisitDay(3);
        assertTrue(specialDay.isContained(List.of(3, 10, 17)));
    }

    @DisplayName("방문 날짜 범위가 1 미만 31초과 일경우 예외처리")
    @Test
    void testInvalidVisitDayRange() {
        assertThrows(IllegalArgumentException.class, () -> new VisitDay(0));
        assertThrows(IllegalArgumentException.class, () -> new VisitDay(32));
    }

}