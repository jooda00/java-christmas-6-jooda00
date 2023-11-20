package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class EventDiscount {
    private static final int TOTAL_AMOUNT_BEFORE_BENEFIT = 120000;
    private final Event event;
    private final List<Discount> discounts = new ArrayList<>();

    public EventDiscount(Event event) {
        this.event = event;
        initializeDiscounts();
    }

    private void initializeDiscounts() {
        discounts.add(new ChristmasDiscount());
        discounts.add(new WeekdayDiscount());
        discounts.add(new WeekendDiscount());
        discounts.add(new SpecialDiscount());
    }

    public void calculateDiscounts() {
        for (Discount discount : discounts) {
            if (discount.isApplicable(event)) {
                discount.calculate(event);
            }
        }
    }

    public int calculateTotalDiscount() {
        int totalDiscount = 0;
        for (Discount discount : discounts) {
            totalDiscount += discount.getDiscountAmount();
        }
        return totalDiscount;
    }

    public int calculateTotalBenefit() {
        int totalBenefit = calculateTotalDiscount();
        if (event.getTotal() > TOTAL_AMOUNT_BEFORE_BENEFIT) {
            totalBenefit += EventMenu.CHAMPAGNE.getPrice();
        }
        return totalBenefit;
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
}
