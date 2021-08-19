package com.projectjavasem4.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.service.IProductService;

@RestController(value = "ProductAPIOfAdmin")

@RequestMapping("/api/product")
public class ProductAPI {

	@Autowired
	private IProductService proService;

	@GetMapping("")
	public List<ProductDTO> getAll() {
		List<ProductDTO> all = proService.getAll();
		return all;
	}

	@GetMapping("/{id}")
	public ProductDTO getBId(@PathVariable long id) {
		return proService.findById(id);
	}

	@PostMapping("")
	public String inserOrUpdate(@RequestBody ProductDTO pro) {
		return  (proService.save(pro)) ? "true" :"false" ;
	}

}
