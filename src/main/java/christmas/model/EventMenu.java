package christmas.model;

import java.util.List;
import java.util.Map;

public enum EventMenu {
    SOUP("양송이수프", 6000, "APPETIZER"),
    TAPAS("타파스", 5000, "APPETIZER"),
    SALAD("시저샐러드", 8000, "APPETIZER"),

    STEAK("티본스테이크", 55000, "MAIN"),
    BARBECUE("바비큐립", 54000, "MAIN"),
    PASTA("해산물파스타", 35000, "MAIN"),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, "MAIN"),

    CAKE("초코케이크", 15000, "DESSERT"),
    ICE_CREAM("아이스크림", 5000, "DESSERT"),

    COKE("제로콜라", 3000, "DRINK"),
    WINE("레드와인", 60000, "DRINK"),
    CHAMPAGNE("샴페인", 25000, "DRINK"),

    NONE("없음", 0, "NONE");

    private String menu;
    private int price;
    private String type;

    EventMenu(String menu, int price, String type) {
        this.menu = menu;
        this.price = price;
        this.type = type;
    }

    public String getMenu() {
        return menu;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static int calculateTotalPrice(String name, Integer count) {
        for (EventMenu menu : EventMenu.values()) {
            if (menu.getMenu().equals(name)) {
                return menu.getPrice() * count;
            }
        }
        return 0;
    }

    public static int calculateDessertCount(Map<String, Integer> menus) {
        int count = 0;
        for (Map.Entry<String, Integer> menu : menus.entrySet()) {
            count += isDessertType(menu.getKey(), menu.getValue());
        }
        return count;
    }

    public static int caculateMainCount(Map<String, Integer> menus) {
        int count = 0;
        for (Map.Entry<String, Integer> menu : menus.entrySet()) {
            count += isMainType(menu.getKey(), menu.getValue());
        }
        return count;
    }

    public static boolean isValidMenu(String input) {
        for (EventMenu menu : EventMenu.values()) {
            if (menu.getMenu().equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllDrinks(List<String> menus) {
        for (String menu : menus) {
            if (!isOnlyDrinkType(menu)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOnlyDrinkType(String input) {
        for (EventMenu menu : EventMenu.values()) {
            if (menu.getMenu().equalsIgnoreCase(input) && menu.getType().equals("DRINK")) {
                return true;
            }
        }
        return false;
    }

    private static int isDessertType(String menu, Integer count) {
        for (EventMenu eventMenu : EventMenu.values()) {
            if (eventMenu.getMenu().equals(menu) && eventMenu.getType().equals("DESSERT")) {
                return count;
            }
        }
        return 0;
    }

    private static int isMainType(String menu, Integer count) {
        for (EventMenu eventMenu : EventMenu.values()) {
            if (eventMenu.getMenu().equals(menu) && eventMenu.getType().equals("MAIN")) {
                return count;
            }
        }
        return 0;
    }
}
