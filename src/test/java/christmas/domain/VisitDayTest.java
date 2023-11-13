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



}