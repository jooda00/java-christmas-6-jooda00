package christmas.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Event {
    private static final int CHRISTMAS_DAY = 25;
    private static final int DISCOUNT_AMOUNT = 2023;
    private final int date;
    private final Map<String, Integer> menus = new LinkedHashMap<>();

    public Event(int date) {
        this.date = date;
    }

    public void addMenu(String menu, int count) {
        menus.put(menu, count);
    }

    public int getDate() {
        return date;
    }

    public Map<String, Integer> getMenus() {
        return menus;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Map.Entry<String, Integer> pair : menus.entrySet()) {
            total += EventMenu.calculateTotalPrice(pair.getKey(), pair.getValue());
        }
        return total;
    }

    public int executeChristmasDiscount() {
        int discount = 1000;
        if (this.date <= CHRISTMAS_DAY) {
            discount += 100 * (this.date - 1);
            return discount;
        }
        return 0;
    }

    public int executeWeekdayDiscount() {
        int discount = 0;
        if (EventDay.isWeekDay(this.date)) {
            discount = EventMenu.calculateDessertCount(this.getMenus());
            return discount * DISCOUNT_AMOUNT;
        }
        return discount;
    }

    public int executeWeekendDiscount() {
        int discount = 0;
        if (EventDay.isWeekend(this.date)) {
            discount = EventMenu.caculateMainCount(this.getMenus());
            return discount * DISCOUNT_AMOUNT;
        }
        return discount;
    }
}
