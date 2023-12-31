package christmas.controller;

import christmas.model.Event;
import christmas.model.EventDiscount;
import christmas.util.Util;
import christmas.validator.EventValidator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventController {
    private static final int STANDARD_TOTAL_PRICE = 10000;
    private Event event;
    private EventDiscount eventDiscount;

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
        event.calculateTotalPrice();
        OutputView.printTotalPriceBeforeDiscount(event.getTotal());
        OutputView.printFreebieMenu(event.getTotal());
    }

    private void progressEvent() {
        eventDiscount = new EventDiscount(event);
        OutputView.printBenefits(event.getTotal());
        if (event.getTotal() >= STANDARD_TOTAL_PRICE) {
            getDiscounts();
        }
        int totalBenefit = eventDiscount.calculateTotalBenefit();
        OutputView.printTotalDiscount(totalBenefit);
        OutputView.printExceptedPriceAfterDiscount(event.getTotal() - eventDiscount.calculateTotalDiscount());
        OutputView.printEventBadge(totalBenefit);
    }

    private int getDate() {
        try {
            int date = InputView.readDate();
            EventValidator.validateDate(date);
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
            Util.validateMenus(menus);
            List<Integer> counts = Util.extractCount(pairs);
            Util.validateCounts(counts);
            initializeEvent(menus, counts);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e);
            getMenus();
        }
    }

    private void getDiscounts() {
        eventDiscount.calculateDiscounts();
        OutputView.printEachBenefit(eventDiscount);
        OutputView.printFreebieBenefit(event.getTotal());
    }

    private void initializeEvent(List<String> menus, List<Integer> counts) {
        for (int i = 0; i < menus.size(); i++) {
            event.addMenu(menus.get(i), counts.get(i));
        }
    }
}
