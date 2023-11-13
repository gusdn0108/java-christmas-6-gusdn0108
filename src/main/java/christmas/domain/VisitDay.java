package christmas.domain;

import christmas.utils.ErrorMessage;
import java.util.List;

public class VisitDay {
    private final int day;
    private static final int INSERT_DAY_MIN_RANGE = 1;
    private static final int INSERT_DAY_MAX_RANGE = 31;


    public VisitDay(int day) {
        validate(day);
        this.day = day;
    }

    private static void dayRange(int day) {
        if (day < INSERT_DAY_MIN_RANGE || day > INSERT_DAY_MAX_RANGE) {
            throw new IllegalArgumentException(ErrorMessage.INSERT_DAY_RANGE_ERROR.getMessage());
        }
    }

    private void validate(int day) {
        dayRange(day);
    }

    public boolean isWeekend() {
        int mod = day % 7;
        return mod == 1 || mod == 2;
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    public int getDay() {
        return day;
    }

    public boolean isContained(List<Integer> days) {
        return days.contains(day);
    }
}
