package christmas.model;

public class WeekendDiscount extends Discount {
    private static final int DISCOUNT_AMOUNT = 2023;

    @Override
    public boolean isApplicable(Event event) {
        return EventDay.isWeekend(event.getDate());
    }

    @Override
    public void calculate(Event event) {
        discountAmount = EventMenu.calculateMainCount(event.getMenus()) * DISCOUNT_AMOUNT;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getTypeName() {
        typeName = "주말 할인";
        return typeName;
    }
}
