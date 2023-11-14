package christmas.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Event {
    private final int date;
    private final Map<String, Integer> menus = new LinkedHashMap<>();
    private int total = 0;

    public Event(int date) {
        this.date = date;
    }

    public void addMenu(String menu, int count) {
        menus.put(menu, count);
    }

    public void calculateTotalPrice() {
        for (Map.Entry<String, Integer> pair : menus.entrySet()) {
            this.total += EventMenu.calculateTotalPrice(pair.getKey(), pair.getValue());
        }
    }

    public int getDate() {
        return date;
    }

    public Map<String, Integer> getMenus() {
        return menus;
    }

    public int getTotal() {
        return total;
    }
}
