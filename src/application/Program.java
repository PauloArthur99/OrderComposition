package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf2.parse(sc.next());
		
		Client client= new Client(name, email, birthDate);
		
		Date moment = new Date();
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String orderStatus = sc.next();
		
		Order order = new Order(moment, OrderStatus.valueOf(orderStatus), client);
		
		System.out.print("How many items to this order?");
		int numOrders = sc.nextInt();
		for (int i = 0; i < numOrders; i++) {
			System.out.printf("Enter #%d item data: %n", i);
			System.out.print("Product name: ");
			String productName = sc.next(); 
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble(); 
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt(); 
			
			order.addItem(new OrderItem(quantity, productPrice, new Product(productName, productPrice)));
		}
		System.out.println("");
		
		System.out.println("ORDER SUMMARY");
		System.out.println(order);
		
		sc.close();
	}

}
