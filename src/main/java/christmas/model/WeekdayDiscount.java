package christmas.model;

public class WeekdayDiscount extends Discount {
    private static final int DISCOUNT_AMOUNT = 2023;

    @Override
    public boolean isApplicable(Event event) {
        return EventDay.isWeekDay(event.getDate());
    }

    @Override
    public void calculate(Event event) {
        discountAmount = EventMenu.calculateDessertCount(event.getMenus()) * DISCOUNT_AMOUNT;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getTypeName() {
        typeName = "평일 할인";
        return typeName;
    }
}
