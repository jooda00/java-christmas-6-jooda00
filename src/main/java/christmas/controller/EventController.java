package christmas.controller;

import christmas.model.Event;
import christmas.util.Util;
import christmas.validation.EventValidation;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventController {
    private Event event;

    public void play() {
        prepareEvent();
    }

    private void prepareEvent() {
        OutputView.printStart();
        int date = getDate();
        event = new Event(date);
        getMenus();
        OutputView.printResult(date);
    }

    private int getDate() {
        try {
            int date = InputView.readDate();
            EventValidation.validateDate(date);
            return date;
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            return getDate();
        }
    }

    private void getMenus() {
        try {
            List<String> list = InputView.readMenuAndCount();
            List<String> menus = Util.extractMenu(list);
            List<Integer> counts = Util.extractCount(list);
            initializeEvent(menus, counts);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            getMenus();
        }
    }

    private void initializeEvent(List<String> menus, List<Integer> counts) {
        for (int i = 0; i < menus.size(); i++) {
            event.addMenu(menus.get(i), counts.get(i));
        }
    }
}
