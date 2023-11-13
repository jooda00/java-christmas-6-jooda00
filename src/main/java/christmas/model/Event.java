package christmas.model;

import java.util.HashMap;
import java.util.Map;

public class Event {
    private final int date;
    private final Map<String, Integer> menus = new HashMap<>();

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
}
