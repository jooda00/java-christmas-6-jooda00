package christmas.view;

import christmas.model.Event;

public class OutputView {
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
}
