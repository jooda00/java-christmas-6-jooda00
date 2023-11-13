package christmas.util;

import camp.nextstep.edu.missionutils.Console;

public class Util {
    public static final String getDate() {
        String date = Console.readLine();
        return date;
    }

    public static final int convertStringToInt(String input) {
        int num = Integer.parseInt(input);
        return num;
    }
}
