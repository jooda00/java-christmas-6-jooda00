package christmas.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Event {
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
}
