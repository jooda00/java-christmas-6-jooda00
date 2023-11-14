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
        EventValidation.validateDateIsNumber(input);
        int num = Integer.parseInt(input);
        return num;
    }

    public static final List<String> separateInput(String input) {
        List<String> pairs = Arrays.asList(input.split(","));
        EventValidation.validateIsCorrectForm(pairs);
        separateInputByDash(pairs);
        return pairs;
    }

    public static final void separateInputByDash(List<String> pairs) {
        for (int i = 0; i < pairs.size(); i++) {
            String value = Arrays.asList(pairs.get(i).split("-")).get(1);
            EventValidation.validateValueIsNumber(value);
        }
    }

    public static final List<String> extractMenu(List<String> pairs) {
        List<String> menus = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            String menu = Arrays.asList(pairs.get(i).split("-")).get(0);
            menus.add(menu);
        }
        return menus;
    }

    public static final List<Integer> extractCount(List<String> pairs) {
        List<Integer> counts = new ArrayList<>();
        for (int i = 0; i < pairs.size(); i++) {
            String count = Arrays.asList(pairs.get(i).split("-")).get(1);
            int num = convertStringToInt(count);
            counts.add(num);
        }
        return counts;
    }
}
