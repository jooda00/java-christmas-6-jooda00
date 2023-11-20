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
        event.calculateTotalPrice();
        int total = 255000;

        assertThat(total).isEqualTo(event.getTotal());
    }
}
