package christmas.model;

public class EventDiscount {
    private static final int CHRISTMAS_DAY = 25;
    private static final int DISCOUNT_AMOUNT = 2023;
    private int totalDiscount = 0;

    public int executeChristmasDiscount(Event event) {
        int discount = 1000;
        if (event.getDate() <= CHRISTMAS_DAY) {
            discount += 100 * (event.getDate() - 1);
            return discount;
        }
        return 0;
    }

    public int executeWeekdayDiscount(Event event) {
        int discount = 0;
        if (EventDay.isWeekDay(event.getDate())) {
            discount = EventMenu.calculateDessertCount(event.getMenus());
            return discount * DISCOUNT_AMOUNT;
        }
        return discount;
    }

    public int executeWeekendDiscount(Event event) {
        int discount = 0;
        if (EventDay.isWeekend(event.getDate())) {
            discount = EventMenu.calculateMainCount(event.getMenus());
            return discount * DISCOUNT_AMOUNT;
        }
        return discount;
    }
}
