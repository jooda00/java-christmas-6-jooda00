package christmas.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class EventDiscount {
    private static final int CHRISTMAS_DAY = 25;
    private static final int DISCOUNT_AMOUNT = 2023;
    private static final int TOTAL_AMOUNT_BEFORE_BENEFIT = 120000;
    private final Event event;
    private final Map<String, Integer> discounts = new LinkedHashMap<>();

    public EventDiscount(Event event) {
        this.event = event;
    }

    public void initializeDiscounts() {
        discounts.put("christmas", 0);
        discounts.put("weekday", 0);
        discounts.put("weekend", 0);
        discounts.put("special", 0);
    }

    public int calculateDiscount(String discountType, int discountValue) {
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
        if (EventDay.isWeekDay(event.getDate())) {
            int discount = EventMenu.calculateDessertCount(event.getMenus()) * DISCOUNT_AMOUNT;
            return calculateDiscount("weekday", discount);
        }
        return 0;
    }

    public int executeWeekendDiscount() {
        if (EventDay.isWeekend(event.getDate())) {
            int discount = EventMenu.calculateMainCount(event.getMenus()) * DISCOUNT_AMOUNT;
            return calculateDiscount("weekend", discount);
        }
        return 0;
    }

    public int executeSpecialDiscount() {
        if (EventDay.isSpecialDay(event.getDate())) {
            int discount = 1000;
            return calculateDiscount("special", discount);
        }
        return 0;
    }

    public int calculateTotalDiscount() {
        int totalDiscount = discounts.values().stream().mapToInt(Integer::intValue).sum();
        return totalDiscount;
    }

    public int calculateTotalBenefit() {
        int totalBenefit = calculateTotalDiscount();
        if (event.getTotal() > TOTAL_AMOUNT_BEFORE_BENEFIT) {
            totalBenefit += EventMenu.CHAMPAGNE.getPrice();
        }
        return totalBenefit;
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }
}
