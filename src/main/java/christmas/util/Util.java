package christmas.util;

import camp.nextstep.edu.missionutils.Console;
import christmas.validation.EventValidation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static final String getInput() {
        String date = Console.readLine();
        return date;
    }

    public static final int convertStringToInt(String input) {
        int num = Integer.parseInt(input);
        return num;
    }

    public static final List<String> separateInput(String input) {
        List<String> inputParts = Arrays.asList(input.split(","));
        extractMenu(inputParts);
        extractCount(inputParts);
        return inputParts;
    }

    public static final void extractMenu(List<String> inputParts) {
        List<String> menus = new ArrayList<>();
        for (int i = 0; i < inputParts.size(); i++) {
            String menu = Arrays.asList(inputParts.get(i).split("-")).get(0);
            menus.add(menu);
            EventValidation.validateDuplication(menus);
            EventValidation.validateIsExistedMenu(menu);
        }
    }

    public static final void extractCount(List<String> inputParts) {
        for (int i = 0; i < inputParts.size(); i++) {
            String count = Arrays.asList(inputParts.get(i).split("-")).get(1);
            int num = convertStringToInt(count);
            EventValidation.validateOverSTANDARD_COUNT(num);
        }
    }
}
