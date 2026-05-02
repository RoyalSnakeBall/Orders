public class Order {
    private int id;
    private String customerName;
    private double totalPrice;
    private int itemsCount;
    private  OrderStatus status;
    private double discount;

    public Order(int id, String customerName, double totalPrice, int itemsCount, OrderStatus status, double discount) {
        this.id = id;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.itemsCount = itemsCount;
        this.status = status;
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                ", itemsCount=" + itemsCount +
                ", status=" + status +
                ", discount=" + discount +
                '}';
    }
}
