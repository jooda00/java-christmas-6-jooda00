package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventDiscountTest {
    private Event event;
    private EventDiscount eventDiscount;

    @BeforeEach
    void setUp() {
        event = new Event(25);
        eventDiscount = new EventDiscount(event);
        event.addMenu("티본스테이크", 1);
        event.addMenu("초코케이크", 2);
        event.addMenu("제로콜라", 1);
        event.addMenu("타파스", 1);
        eventDiscount.calculateDiscounts();
    }

    @Test
    void 크리스마스_디데이_할인() {
        int discount = 3400;

        assertThat(discount).isEqualTo(eventDiscount.getDiscounts().get(0).getDiscountAmount());
    }

    @Test
    void 평일_할인() {
        int discount = 4046;

        assertThat(discount).isEqualTo(eventDiscount.getDiscounts().get(1).getDiscountAmount());
    }

    @Test
    void 주말_할인() {
        event = new Event(23);
        eventDiscount = new EventDiscount(event);
        event.addMenu("티본스테이크", 3);
        event.addMenu("초코케이크", 2);
        event.addMenu("레드와인", 1);
        eventDiscount.calculateDiscounts();
        int discount = 6069;

        assertThat(discount).isEqualTo(eventDiscount.getDiscounts().get(2).getDiscountAmount());
    }

    @Test
    void 특별_할인() {
        int discount = 1000;

        assertThat(discount).isEqualTo(eventDiscount.getDiscounts().get(3).getDiscountAmount());
    }

    @Test
    void 증정_메뉴가_없는_총혜택_금액() {
        int totalBenefit = 8446;

        assertThat(totalBenefit).isEqualTo(eventDiscount.calculateTotalBenefit());
    }
}
