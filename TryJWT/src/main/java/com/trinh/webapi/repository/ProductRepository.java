package com.trinh.webapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trinh.webapi.model.Category;
import com.trinh.webapi.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	public Boolean existsByName(String name);
	public List<Product> findAllByCategory(Category category, Pageable pageable);
	public List<Product> findAllByStatus(boolean status, Pageable pageable);
	public List<Product> findAllByStatus(boolean status);
	public int countByCategory(Category category);
	public List<Product> findAllByCategory(Category category);

}