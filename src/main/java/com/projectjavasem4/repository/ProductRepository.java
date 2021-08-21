package com.projectjavasem4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.ProductEntity;



//@Repository
//@Component
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findByName(String name);
	ProductEntity findBySlug(String slug);
}
