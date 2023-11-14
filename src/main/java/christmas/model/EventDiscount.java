package christmas.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class EventDiscount {
    private static final int CHRISTMAS_DAY = 25;
    private static final int DISCOUNT_AMOUNT = 2023;
    private final Event event;
    private final Map<String, Integer> discounts = new LinkedHashMap<>();

    public EventDiscount(Event event) {
        this.event = event;
    }

    private int calculateDiscount(String discountType, int discountValue) {
        discounts.put(discountType, discountValue);
        return discountValue;
    }

    public int executeChristmasDiscount() {
        int discount = 1000;
        if (event.getDate() <= CHRISTMAS_DAY) {
            return calculateDiscount("christmas", discount + 100 * (event.getDate() - 1));
        }
        return calculateDiscount("christmas", discount);
    }

    public int executeWeekdayDiscount() {
        int discount = 0;
        if (EventDay.isWeekDay(event.getDate())) {
            discount = EventMenu.calculateDessertCount(event.getMenus());
            discount *= DISCOUNT_AMOUNT;
        }
        return calculateDiscount("weekday", discount);
    }

    public int executeWeekendDiscount() {
        int discount = 0;
        if (EventDay.isWeekend(event.getDate())) {
            discount = EventMenu.calculateMainCount(event.getMenus());
            discount *= DISCOUNT_AMOUNT;
        }
        return calculateDiscount("weekend", discount);
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }
}
