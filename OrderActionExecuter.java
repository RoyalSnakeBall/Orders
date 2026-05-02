import java.util.HashMap;
import java.util.Map;

public class OrderActionExecuter {
    Map<OrderAction, OrderProcessor> orderActionOrderProcessorMap = new HashMap<>();
    Map<OrderAction, OrderCalculator> orderActionOrderCalculatorMap = new HashMap<>();

    public OrderActionExecuter() {
        orderActionOrderProcessorMap.put(OrderAction.APPLY_DISCOUNT, order -> {
            if (order.getTotalPrice() >= 1000) {
                order.setDiscount(order.getTotalPrice() * 0.1);
            } else {
                order.setDiscount(order.getTotalPrice() * 0.05);
            }
        });
        orderActionOrderCalculatorMap.put(OrderAction.CALCULATE_FINAL_PRICE, order ->
                order.getTotalPrice() - order.getDiscount()

        );
        orderActionOrderProcessorMap.put(OrderAction.CANCEL_ORDER, order ->
                order.setStatus(OrderStatus.CANCELLED)
        );
        orderActionOrderCalculatorMap.put(OrderAction.CHECK_ELIGIBILITY_FOR_FREE_SHIPPING, order -> {
            if (order.getTotalPrice() - order.getDiscount() >= 500) {
                return 1;
            } else {
                return 0;
            }
        });
    }
    public void execute(Order order, OrderAction action){
        OrderProcessor processor = orderActionOrderProcessorMap.get(action);
        if (processor != null) {
            processor.process(order);
        }
    }
    public double calculate(Order order, OrderAction action){
        OrderCalculator orderCalculator = orderActionOrderCalculatorMap.get(action);
        return orderCalculator.calculate(order);

    }
}
