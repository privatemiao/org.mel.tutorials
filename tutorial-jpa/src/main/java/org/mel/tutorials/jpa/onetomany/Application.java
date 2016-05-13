package org.mel.tutorials.jpa.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	OrderRepository orderDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... args) throws Exception {
		Order order = new Order();
		Set<OrderItem> items = new HashSet<OrderItem>();
		items.add(new OrderItem("iPod", 500F, order));
		items.add(new OrderItem("iMac", 12000F, order));
		order.setOrderNo("O0001");
		order.setAmount(12500F);
		order.setItems(items);
		orderDao.save(order);
	}

}
