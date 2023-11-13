package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public void play() {
        prepareEvent();
    }

    private void prepareEvent() {
        OutputView.printStart();
        int date = getDate();
        String menu = getMenu();
        OutputView.printResult(date);
    }

    private int getDate() {
        try {
            int date = InputView.readDate();
            return date;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return getDate();
        }
    }

    private String getMenu() {
        try {
            String menu = InputView.readMenuAndCount();
            return menu;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return getMenu();
        }
    }
}
