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
        event = new Event(getDate());
        getMenus();
        OutputView.printResult(event.getDate());
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
            List<String> pairs = InputView.readMenuAndCount();
            List<String> menus = Util.extractMenu(pairs);
            validateMenus(menus);
            List<Integer> counts = Util.extractCount(pairs);
            validateCounts(counts);
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

    private void validateMenus(List<String> menus) {
        for (String menu : menus) {
            EventValidation.validateIsExistedMenu(menu);
        }
        EventValidation.validateDuplication(menus);
        EventValidation.validateIsOnlyDrinkType(menus);
    }

    private void validateCounts(List<Integer> counts) {
        int total = 0;
        for (int count : counts) {
            EventValidation.validateOverSTANDARD_COUNT(count);
            total += count;
        }
        EventValidation.validateOverMAX_COUNT(total);
    }
}
