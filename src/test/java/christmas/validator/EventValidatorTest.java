package christmas.validator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventValidatorTest {
    @Test
    void 날짜에_문자_입력_시_예외_처리() {
        String date = "date";

        assertThatThrownBy(() -> EventValidator.validateDateIsNumber(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }
}
