package christmas.view;

import christmas.model.Event;
import christmas.model.EventDiscount;

import java.text.DecimalFormat;

public class OutputView {
    static DecimalFormat formatter = new DecimalFormat("###,###");

    public static final void printStart() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static final void printResult(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static final void printMenus(Event event) {
        System.out.println("\n<주문 메뉴>");
        event.getMenus().forEach((k, v)
                -> System.out.println(String.format("%s %s개", k, v)));
    }

    public static final void printTotalPriceBeforeDiscount(int price) {
        System.out.println("\n<할인 전 총주문 금액>");
        System.out.println(formatter.format(price) + "원");
    }

    public static final void printFreebieMenu(int total) {
        System.out.println("\n<증정 메뉴>");
        if (total > 120000) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public static final void printBenefits(int total) {
        System.out.println("\n<혜택 내역>");
        if (total < 10000) {
            System.out.println("없음");
        }
    }

    public static final void printEachBenefit(EventDiscount eventDiscount) {
        if (eventDiscount.getDiscounts().get("christmas") != 0) {
            System.out.println("크리스마스 디데이 할인: " + "-" + formatter.format(eventDiscount.getDiscounts()
                    .get("christmas")) + "원");
        }
        if (eventDiscount.getDiscounts().get("weekday") != 0) {
            System.out.println("평일 할인: " + "-" + formatter.format(eventDiscount.getDiscounts()
                    .get("weekday")) + "원");
        }
        if (eventDiscount.getDiscounts().get("weekend") != 0) {
            System.out.println("주말 할인: " + "-" + formatter.format(eventDiscount.getDiscounts()
                    .get("weekend")) + "원");
        }
        if (eventDiscount.getDiscounts().get("special") != 0) {
            System.out.println("특별 할인: " + "-" + formatter.format(eventDiscount.getDiscounts()
                    .get("special")) + "원");
        }
    }

    public static void printFreebieBenefit(int total) {
        if (total > 120000) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    public static void printTotalDiscount(int totalBenefit) {
        System.out.println("\n<총혜택 금액>");
        if (totalBenefit != 0) {
            System.out.println("-" + formatter.format(totalBenefit) + "원");
            return;
        }
        System.out.println(formatter.format(totalBenefit) + "원");
    }

    public static void printExceptedPriceAfterDiscount(int price) {
        System.out.println("\n<할인 후 예상 결제 금액>");
        System.out.println(formatter.format(price) + "원");
    }
}
