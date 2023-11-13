package christmas.validation;

import christmas.model.EventMenu;

import java.util.List;

public class EventValidation {
    private static final int STANDARD_COUNT = 1;

    public static final void validateDate(int date) {
        if ((date < 1 || date > 31)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static final void validateIsExistedMenu(String input) {
        if (!EventMenu.isValidMenu(input)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static final void validateOverSTANDARD_COUNT(int input) {
        if (input < STANDARD_COUNT) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static final void validateDuplication(List<String> menus) {
        if (menus.size() != menus.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
