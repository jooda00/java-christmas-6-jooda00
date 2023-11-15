package christmas.view;

import christmas.model.Discount;
import christmas.model.Event;
import christmas.model.EventDiscount;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final int STANDARD_TOTAL_PRICE = 10000;
    private static final int TOTAL_PRICE_BEFORE_DISCOUNT = 120000;
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
        if (total > TOTAL_PRICE_BEFORE_DISCOUNT) {
            System.out.println("샴페인 1개");
            return;
        }
        System.out.println("없음");
    }

    public static final void printBenefits(int total) {
        System.out.println("\n<혜택 내역>");
        if (total < STANDARD_TOTAL_PRICE) {
            System.out.println("없음");
        }
    }

    public static final void printEachBenefit(EventDiscount eventDiscount) {
        List<Discount> discounts = eventDiscount.getDiscounts();
        for (Discount discount : discounts) {
            if (discount.getDiscountAmount() != 0) {
                System.out.println(discount.getTypeName() + ": -" + formatter.format(discount.getDiscountAmount()) + "원");
            }
        }
    }

    public static void printFreebieBenefit(int total) {
        if (total > TOTAL_PRICE_BEFORE_DISCOUNT) {
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

    public static void printEventBadge(int totalBenefit) {
        System.out.println("\n<12월 이벤트 배지>");
        if (totalBenefit >= 20000) {
            System.out.println("산타");
            return;
        }
        if (totalBenefit >= 10000) {
            System.out.println("트리");
            return;
        }
        if (totalBenefit >= 5000) {
            System.out.println("별");
            return;
        }
        System.out.println("없음");
    }
}
