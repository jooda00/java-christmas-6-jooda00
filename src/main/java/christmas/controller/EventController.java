package christmas.controller;

import christmas.model.Event;
import christmas.model.EventDiscount;
import christmas.util.Util;
import christmas.validation.EventValidation;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.List;

public class EventController {
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
        eventDiscount.initializeDiscounts();
        OutputView.printBenefits(event.getTotal());
        if (event.getTotal() >= 10000) {
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
        eventDiscount.executeChristmasDiscount();
        eventDiscount.executeWeekdayDiscount();
        eventDiscount.executeWeekendDiscount();
        eventDiscount.executeSpecialDiscount();
        OutputView.printEachBenefit(eventDiscount);
        OutputView.printFreebieBenefit(event.getTotal());
    }

    private void initializeEvent(List<String> menus, List<Integer> counts) {
        for (int i = 0; i < menus.size(); i++) {
            event.addMenu(menus.get(i), counts.get(i));
        }
    }
}
