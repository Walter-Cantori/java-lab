package com.shoppingList;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.shoppingList.domain.ListItem;
import com.shoppingList.domain.Product;
import com.shoppingList.domain.ShoppingList;
import com.shoppingList.domain.User;
import com.shoppingList.repository.ListItemRepository;
import com.shoppingList.repository.ProductRepository;
import com.shoppingList.repository.ShoppingListRepository;
import com.shoppingList.repository.UserRepository;

@SpringBootApplication
public class ShoppingListApplication implements CommandLineRunner{
	
	@Autowired
	private ListItemRepository listItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShoppingListRepository shoppingListRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);

	}
	
	public void run(String... args) {
		User user1 = new User(null, "user1", "user1@gmail.com", bcrypt.encode("1234"));
		User user2 = new User(null, "user2", "user2@gmail.com", bcrypt.encode("1234"));
		User user3 = new User(null, "user3", "user3@gmail.com", bcrypt.encode("1234"));
		userRepository.saveAll(Arrays.asList(user1, user2, user3));
		
		Product p1 = new Product(null, "café", "café.jpg");
		Product p2 = new Product(null, "Leite", "leite.jpg");
		productRepository.saveAll(Arrays.asList(p1, p2));
		
		ShoppingList s1 = new ShoppingList(null, "lista1", new Date(), user1);
		ShoppingList s2 = new ShoppingList(null, "lista2", new Date(), user1);
		ShoppingList s3 = new ShoppingList(null, "lista3", new Date(), user2);
		ShoppingList s4 = new ShoppingList(null, "lista4", new Date(), user3);
		shoppingListRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		
		ListItem i1 = new ListItem(null, 10.00, 1);
		ListItem i2 = new ListItem(null, 20.65, 3);
		ListItem i3 = new ListItem(null, 30.90, 4);
		ListItem i4 = new ListItem(null, 25.88, 5);
		
		i1.setProduct(p1);
		i2.setProduct(p2);
		i3.setProduct(p1);
		i4.setProduct(p2);
		
		i1.setList(s1);
		i2.setList(s2);
		i3.setList(s3);
		i4.setList(s4);
		
		listItemRepository.saveAll(Arrays.asList(i1, i2, i3, i4));
	}

}

