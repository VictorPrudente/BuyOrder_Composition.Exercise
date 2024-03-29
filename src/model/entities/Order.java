package model.entities;

import model.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> orderItems = new ArrayList<>();

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Double total() {
        double totalSum = 0.0;
        for (OrderItem item : orderItems) {
            totalSum += item.subTotal();
        }
        return totalSum;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Moment: " + sdf.format(moment) + "\n");
        sb.append("Order Status: " + status + "\n");
        sb.append("Client: " +client.clientString() + "\n");
        sb.append("Order Items: \n");
        for (OrderItem items : orderItems){
            sb.append(items.toString() + "\n");
        }
        sb.append("Total price: $" + total());

        return sb.toString();
    }
}
