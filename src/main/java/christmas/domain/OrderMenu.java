package christmas.domain;

import java.util.Map;

public class OrderMenu {
    private final Map<Menu, Integer> orderMap;


    public OrderMenu(Map<Menu, Integer> orderMap) {
        // 음료만 주문 x
        // 20개 초과x
        if(isOnlyDrink(orderMap)){
            throw new IllegalArgumentException("음료만 주문할수 없습니다");
        }

        if(isOverMenuCount(orderMap)){
            throw new IllegalArgumentException("20개 초과 주문할수없습니다");
        }

        this.orderMap = orderMap;
    }

    private boolean isOverMenuCount(Map<Menu, Integer> orderMap) {
        int sum = 0;
        for (int count : orderMap.values()) {
            sum += count;
        }
        return sum > 20;
    }

    private boolean isOnlyDrink(Map<Menu, Integer> orderMap) {
        for (Menu menu : orderMap.keySet()) {
            if(menu.getMenuCategory()!= MenuCategory.Drink){
                return false;
            }
        }
        return true;
    }

    public Map<Menu, Integer> getOrderMap() {
        return orderMap;
    }


}
