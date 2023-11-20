package christmas.model;

public class ChristmasDiscount extends Discount {
    private static final int CHRISTMAS_DAY = 25;

    @Override
    public boolean isApplicable(Event event) {
        return event.getDate() <= CHRISTMAS_DAY;
    }

    @Override
    public void calculate(Event event) {
        discountAmount = 1000 + 100 * (event.getDate() - 1);
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public String getTypeName() {
        typeName = "크리스마스 디데이 할인";
        return typeName;
    }
}
