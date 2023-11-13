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
}
