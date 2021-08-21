package com.projectjavasem4.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.projectjavasem4.dto.ProductDTO;
public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);
	List<ProductDTO> getAll();
	int getTotalItem();
	ProductDTO findById(long id);
	ProductDTO findByName(String name);
	ProductDTO findBySlug(String slug);
	boolean save(ProductDTO dto);
	void delete(long[] ids);
	void deleteById(long id);
	
	
}
