package christmas.model;

public abstract class Discount {
    public int discountAmount = 0;
    public String typeName;

    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getTypeName() {
        return typeName;
    }

    public abstract boolean isApplicable(Event event);

    public abstract void calculate(Event event);
}
