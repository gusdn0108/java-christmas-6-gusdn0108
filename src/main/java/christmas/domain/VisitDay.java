package christmas.domain;

public class VisitDay {
    private final int day;

    public VisitDay(int day) {
        if(day < 1 || day > 31){
            throw new IllegalArgumentException("1-31이하 만 가능합니다");
        }
        this.day = day;
    }

    public int getDay() {
        return day;
    }
}
