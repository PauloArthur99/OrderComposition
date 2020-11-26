package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> orderItem = new ArrayList<>();
	
	public Order() {
	}

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
	
	public void addItem(OrderItem item) {
		orderItem.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItem.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem o: orderItem) {
			sum += o.subTotal();
		}
		return sum;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf1.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName());
		sb.append(" (" + sdf2.format(client.getBirthDate()) + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order items: \n");
		for (OrderItem o : orderItem) {
			sb.append(o.toString() + "\n");
		}
		
		sb.append("Total price: $");
		sb.append(total());
		return sb.toString();
	}
	
}
