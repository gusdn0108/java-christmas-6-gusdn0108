package christmas.domain;

import christmas.view.OutputView;

public class VisitDay {
    private final int day;

    public VisitDay(int day) {
            validate(day);
            this.day = day;
    }

    private static void dayRange(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("[ERROR] 날짜는 1-31 까지만 입력 가능합니다");
        }
    }

    private void validate(int day){
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
}
