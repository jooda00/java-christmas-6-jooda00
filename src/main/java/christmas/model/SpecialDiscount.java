package christmas.model;

public class SpecialDiscount extends Discount {
    @Override
    public boolean isApplicable(Event event) {
        return EventDay.isSpecialDay(event.getDate());
    }

    @Override
    public void calculate(Event event) {
        discountAmount = 1000;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getTypeName() {
        typeName = "특별 할인";
        return typeName;
    }
}
