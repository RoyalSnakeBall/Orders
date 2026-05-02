import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderService {
    List<Order> orders = new ArrayList<>();

    public List<Order> getAllPaidOrders(){
        return orders.stream().filter(order -> order.getStatus() == OrderStatus.PAID).toList();
    }
    public double getTotalPrice(){
        return orders.stream().mapToDouble(Order::getTotalPrice).sum();
    }
    public double getCheck(){
        return orders.stream().mapToDouble(Order::getTotalPrice).average().orElse(0);
    }
    public List<Order> getTop3MostExpensiveOrders(){
        return orders.stream().sorted(Comparator.comparing(Order::getTotalPrice).reversed()).limit(3).toList();
    }
    public Map<OrderStatus, List<Order>> groupOrdersByStatus(){
        return orders.stream().collect(Collectors.groupingBy(Order::getStatus));
    }
    public List<Order> findOrderWithMaxAmountOfOrders(){
        return orders.stream().sorted(Comparator.comparing(Order::getItemsCount).reversed()).limit(1).toList();
    }
    public List<Order> filterOrderWithThePriceBigger(int num){
        return orders.stream().filter(order -> order.getTotalPrice() > num).toList();
    }


    public OrderService() {
        orders.add(new Order(1, "Alice", 1200, 5, OrderStatus.PAID, 0));
        orders.add(new Order(2, "Bob", 300, 2, OrderStatus.NEW, 0));
        orders.add(new Order(3, "Charlie", 700, 3, OrderStatus.PAID, 0));
        orders.add(new Order(4, "David", 1500, 7, OrderStatus.SHIPPED, 0));
        orders.add(new Order(5, "Eve", 200, 1, OrderStatus.PAID, 0));
    }
}
