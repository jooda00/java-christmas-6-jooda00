package christmas.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class EventValidatorTest {
    @Test
    void 날짜에_문자_입력_시_예외_처리() {
        String date = "date";

        assertThatThrownBy(() -> EventValidator.validateDateIsNumber(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    void 날짜가_범위에_없으면_예외_처리() {
        int date = 32;

        assertThatThrownBy(() -> EventValidator.validateDate(date))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_입력값에_공백_포함_시_예외_처리() {
        List<String> pairs = Arrays.asList("초코케이크-  2");

        assertThatThrownBy(() -> EventValidator.validateIsCorrectForm(pairs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_입력값에_개수가_숫자가_아니면_예외_처리() {
        String value = "count";

        assertThatThrownBy(() -> EventValidator.validateValueIsNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_입력값에_메뉴가_메뉴판에_존재하지_않으면_예외_처리() {
        String input = "케이크";

        assertThatThrownBy(() -> EventValidator.validateIsExistedMenu(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 주문_메뉴가_1개_미만이면_예외_처리() {
        int input = 0;

        assertThatThrownBy(() -> EventValidator.validateOverSTANDARD_COUNT(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 메뉴_입력값에_메뉴가_겹치면_예외_처리() {
        List<String> menus = Arrays.asList("초코케이크", "타파스","초코케이크");

        assertThatThrownBy(() -> EventValidator.validateDuplication(menus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    void 주문_메뉴_합계가_20개가_넘으면_예외_처리() {
        int sum = 21;

        assertThatThrownBy(() -> EventValidator.validateOverMAX_COUNT(sum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 메뉴는 총 합계 20개를 넘길 수 없습니다.");
    }
}
