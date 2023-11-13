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

    public String getDayType(int day) {
        int dayOfWeek = (day + 5) % 7;
        String dayType = "주말";
        if (dayOfWeek >= 1 && dayOfWeek <= 5) {
            dayType = "평일";
        }
        return dayType;
    }

    public String specialDay(int day) {
        String dayType = "별";
        if (day == 3 || day == 10 || day == 17 || day == 24 || day == 25 || day == 31) {
            dayType = "별";
        }
        return dayType;
    }


    public int getDay() {
        return day;
    }
}
