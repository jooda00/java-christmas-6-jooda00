package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    private Event event;

    @BeforeEach
    void setUp() {
        event = new Event(25);
        event.addMenu("티본스테이크", 3);
        event.addMenu("초코케이크", 2);
        event.addMenu("레드와인", 1);
    }

    @Test
    void 할인_전_총주문_금액_계산() {
        int total = 200000;

        assertThat(total).isEqualTo(event.calculateTotalPrice());
    }

    @Test
    void 크리스마스_디데이_할인() {
        int discount = 3400;

        assertThat(discount).isEqualTo(event.executeChristmasDiscount());
    }

    @Test
    void 평일_할인() {
        int discount = 4046;

        assertThat(discount).isEqualTo(event.executeWeekdayDiscount());
    }

    @Test
    void 주말_할인() {
        int discount = 6069;

        assertThat(discount).isEqualTo(event.executeWeekendDiscount());
    }
}
