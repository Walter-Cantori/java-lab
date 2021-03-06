package com.shoppingList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingList.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	Product findByName(String product);

}
