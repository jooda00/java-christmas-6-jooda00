package christmas.model;

import java.util.Arrays;
import java.util.List;

public enum EventDay {
    WEEKDAY(Arrays.asList(3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31), "WEEKDAY"),
    WEEKEND(Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30), "WEEKEND"),
    SPECIAL(Arrays.asList(3, 10, 17, 24, 25, 31), "SPECIAL");

    private List<Integer> days;
    private String type;

    EventDay(List<Integer> days, String type) {
        this.days = days;
        this.type = type;
    }

    public List<Integer> getDays() {
        return days;
    }

    public static boolean isWeekDay(int date) {
        if (EventDay.WEEKDAY.getDays().contains(date)) {
            return true;
        }
        return false;
    }

    public static boolean isWeekend(int date) {
        if (EventDay.WEEKEND.getDays().contains(date)) {
            return true;
        }
        return false;
    }

    public static boolean isSpecialDay(int date) {
        if (EventDay.SPECIAL.getDays().contains(date)) {
            return true;
        }
        return false;
    }
}
