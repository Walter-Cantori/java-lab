package com.shoppingList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingList.domain.ListItem;
import com.shoppingList.domain.ShoppingList;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Integer>{
	List<ListItem> findByList(ShoppingList list);

}
