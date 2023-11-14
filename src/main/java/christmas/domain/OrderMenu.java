package christmas.domain;

import christmas.utils.ErrorMessage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMenu {
    private final Map<Menu, Integer> orderMap;


    public OrderMenu(Map<Menu, Integer> orderMap) {
        validate(orderMap);
        this.orderMap = orderMap;
    }

    private void validate(Map<Menu, Integer> orderMap) {
        if (isOnlyDrink(orderMap)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ORDER_ONLY_DRINK.getMessage());
        }
        if (isOverMenuCount(orderMap)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_ORDER_TWENTY_MENU.getMessage());
        }
        if (isOverMinOrder(orderMap)) {
            throw new IllegalArgumentException(ErrorMessage.USER_INSERT_NOT_AVAILABLE_MENU.getMessage());
        }
    }

    private boolean isOverMenuCount(Map<Menu, Integer> orderMap) {
        int sum = 0;
        for (int count : orderMap.values()) {
            sum += count;
        }
        return sum > 20;
    }

    private boolean isOverMinOrder(Map<Menu, Integer> orderMap) {
        int sum = 0;
        for (int count : orderMap.values()) {
            sum += count;
        }
        return sum < 1;
    }

    private boolean isOnlyDrink(Map<Menu, Integer> orderMap) {
        for (Menu menu : orderMap.keySet()) {
            if (menu.getMenuCategory() != MenuCategory.Drink) {
                return false;
            }
        }
        return true;
    }

    public int totalPrice() {
        int sum = 0;
        for (Map.Entry<Menu, Integer> entry : orderMap.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            sum += menu.getPrice() * quantity;
        }
        return sum;
    }

    public List<Menu> getMenuInCategory(MenuCategory menuCategory) {
        return orderMap.keySet().stream()
                .filter(menu -> menu.isCategory(menuCategory))
                .collect(Collectors.toList());
    }

    public int getOrderCount(Menu categroyMenu) {
        return orderMap.get(categroyMenu);
    }

    public Map<Menu, Integer> getOrderMap() {
        return orderMap;
    }

}
