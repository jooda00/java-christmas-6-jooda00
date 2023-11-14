package christmas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EventTest {
    private Event event;
    private Map<String, Integer> menus = new LinkedHashMap<>();

    @BeforeEach
    void setUp() {
        event = new Event(25);
        event.addMenu("초코케이크", 2);
        event.addMenu("레드와인", 1);
    }

    @Test
    void 크리스마스_디데이_할인() {
        int discount = 3400;

        assertThat(discount).isEqualTo(event.executeChristmasDiscount());
    }
}
