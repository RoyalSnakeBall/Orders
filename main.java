import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderService orderService = new OrderService();
        OrderActionExecuter executer = new OrderActionExecuter();


        boolean isWork = true;
        while(isWork){
            System.out.println(" 1-getAllPaidOrders\n 2-getTotalPrice\n 3-getCheck\n 4-getTop3MostExpensiveOrders\n 5-groupOrdersByStatus\n 6-findOrderWithMaxAmountOfOrders\n 7-filterOrderWithThePriceBigger\n 8-exit\n 9-apply discount to all paid orders\n 10-calculate final price of first order");
            int answer = scanner.nextInt();

            if(answer == 1){
                System.out.println("All paid orders: " + orderService.getAllPaidOrders());
            }
            else if(answer == 2){
                System.out.println("Get total price: " + orderService.getTotalPrice());
            }
            else if(answer == 3){
                System.out.println("Get check: " + orderService.getCheck());
            }
            else if(answer == 4){
                System.out.println("Get top 3 of the most expensive orders: " + orderService.getTop3MostExpensiveOrders());
            }
            else if(answer == 5){
                System.out.println("Group orders by status: " + orderService.groupOrdersByStatus());
            }
            else if(answer == 6){
                System.out.println("Find an order with max amount of orders: " + orderService.findOrderWithMaxAmountOfOrders());
            }
            else if(answer == 7){
                System.out.println("Enter a number: ");
                int number = scanner.nextInt();

                System.out.println("Filter order with the price bigger than " + number  + orderService.filterOrderWithThePriceBigger(number));
            }
            else if(answer == 8){
                System.out.println("Exiting...");
                isWork = false;
            }
            else if(answer == 9){
                for (Order order : orderService.getAllPaidOrders()) {
                    executer.execute(order, OrderAction.APPLY_DISCOUNT);
                }
                System.out.println("Discounts applied!");
            }
            else if(answer == 10){
                List<Order> topOrders = orderService.getTop3MostExpensiveOrders();

                if (topOrders.isEmpty()) {
                    System.out.println("No orders available.");
                } else {
                    Order order = topOrders.getFirst();
                    double finalPrice = executer.calculate(order, OrderAction.CALCULATE_FINAL_PRICE);
                    System.out.println("Final price: " + finalPrice);
                }
            }
        }
    }
}
