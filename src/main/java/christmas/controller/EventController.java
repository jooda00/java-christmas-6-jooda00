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
        progressEventBeforeBenefited();
        progressEvent();
    }

    private void prepareEvent() {
        OutputView.printStart();
        event = new Event(getDate());
        getMenus();
        OutputView.printResult(event.getDate());
    }

    private void progressEventBeforeBenefited() {
        OutputView.printMenus(event);
        int total = event.calculateTotalPrice();
        OutputView.printTotalPriceBeforeDiscount(total);
        OutputView.printFreebieMenu(total);
    }

    private void progressEvent() {
        OutputView.printBenefits();
        int christmasDiscount = event.executeChristmasDiscount();
        OutputView.printChristmasBenefit(christmasDiscount);
        int weekDayDiscount = event.executeWeekdayDiscount();
        OutputView.printWeekdayBenefit(weekDayDiscount);
        int weekEndDiscount = event.executeWeekendDiscount();
        OutputView.printWeekendBenefit(weekEndDiscount);
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
            List<Integer> counts = Util.extractCount(pairs);
            validateMenus(menus);
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
