package com.shoppingList.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingList.domain.ListItem;
import com.shoppingList.service.ListItemService;

@RestController
@RequestMapping(value="/lists/{list_id}/items")
public class ListItemResource {
	@Autowired
	private ListItemService listItemService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ListItem>> getAll(@PathVariable Integer list_id){
		List<ListItem> items = listItemService.getAll(list_id);
		return ResponseEntity.ok().body(items);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ListItem> getOne(@PathVariable Integer list_id, @PathVariable Integer id){
		ListItem item = listItemService.getOne(list_id, id);
		return ResponseEntity.ok().body(item);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<ListItem> create(@PathVariable Integer list_id, @Valid @RequestBody ListItem item){
		ListItem createdItem = listItemService.create(list_id, item);
		return ResponseEntity.ok().body(createdItem);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<ListItem> edit(@PathVariable Integer id, @Valid @RequestBody ListItem item){
		ListItem createdItem = listItemService.edit(id, item);
		return ResponseEntity.ok().body(createdItem);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> destroy(@PathVariable Integer id){
		listItemService.destroy(id);
		return ResponseEntity.ok().build();
	}
}
