package com.shoppingList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingList.domain.ListItem;
import com.shoppingList.domain.Product;
import com.shoppingList.domain.ShoppingList;
import com.shoppingList.repository.ListItemRepository;
import com.shoppingList.service.exceptions.ResourceNotFoundException;

@Service
public class ListItemService {
	@Autowired
	private ListItemRepository listItemRepository;
	
	@Autowired
	private ShoppingListService shoppingListService;
	
	@Autowired
	private ProductService productService;
	
	
	private ListItem findItemById(Integer id) {
		Optional<ListItem> item = listItemRepository.findById(id);
		return item.orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
	}
	
	public List<ListItem> getAll(Integer list_id) {
		ShoppingList list = shoppingListService.getOne(list_id);
		return listItemRepository.findByList(list);
	}
	
	public ListItem getOne(Integer list_id, Integer id) {
		return findItemById(id);
	}
	
	public ListItem create(Integer list_id, ListItem item) {
		item.setId(null);
		ShoppingList list = shoppingListService.getOne(list_id);
		item.setList(list);
		
		Product product = productService.findOrCreate(item.getProduct());
		item.setProduct(product);
		return listItemRepository.save(item);
	}
	
	public ListItem edit(Integer id, ListItem newItemData) {
		ListItem item = findItemById(id);
		item.setPrice(newItemData.getPrice() > 0 ? newItemData.getPrice() : item.getPrice());
		item.setQuantity(newItemData.getQuantity() != null ? newItemData.getQuantity() : item.getQuantity());
		return listItemRepository.save(item);
	}
	
	public void destroy(Integer id) {
		findItemById(id);
		listItemRepository.deleteById(id);
	}
}
