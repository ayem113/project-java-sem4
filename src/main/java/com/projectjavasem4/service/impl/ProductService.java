package com.projectjavasem4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.ProductDTO;
import com.projectjavasem4.entities.ProductEntity;
import com.projectjavasem4.repository.CategoryRepository;
import com.projectjavasem4.repository.GenericRepository;
import com.projectjavasem4.repository.ProductRepository;
import com.projectjavasem4.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private GenericRepository<ProductEntity> proRep;
	@Autowired
	private CategoryRepository CatRep;

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {


		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = proRep.findAll(pageable).getContent();
		for (ProductEntity item : entities) {
			ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
			models.add(p);
		}
		return models;

	}

	@Override
	public int getTotalItem() {
		return (int) proRep.count();
	}

	@Override
	public ProductDTO findById(long id) {

		ProductEntity pro = proRep.findOne(id);

		return new ModelMapper().map(pro, ProductDTO.class);

		// proRep.getOne(id);
	}

	@Override
	public ProductDTO save(ProductDTO dto) {

		/*
		 * ProductEntity pro = new ModelMapper().map(dto, ProductEntity.class);
		 * CategoryEntity c = CatRep.findOne(dto.getId_category()); pro.setCategory(c);
		 * ProductEntity t = proRep.save(pro); ProductDTO p = new ModelMapper().map(t,
		 * ProductDTO.class); p.setId_category(c.getId());
		 */

		ProductEntity kq = new ProductEntity();
		BeanUtils.copyProperties(dto, kq);

		return new ModelMapper().map(kq, ProductDTO.class);

//		try {
//			ProductEntity e = new ProductEntity();
//			e.setCategory(c);
//			for (Field f : dto.getClass().getDeclaredFields()) {
//				for (Field f1 : ProductEntity.class.getDeclaredFields()) {
//					if(f.getName().equals(f1.getName()) && f.getType() == f1.getType()) {
//						if(f1.getType() == int.class) {
//							e.getClass().getField(f1.getName()).setInt(e, dto.getClass().getField(f.getName()).getInt(dto));
//						}
//					}
//				}
//			}
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			return null;
//		}

	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			proRep.delete(id);
		}
	}

	@Override
	public List<ProductDTO> getAll() {
		List<ProductDTO> models = new ArrayList<>();
		List<ProductEntity> entities = proRep.findAll();
		for (ProductEntity item : entities) {
			ProductDTO p = new ModelMapper().map(item, ProductDTO.class);
			p.setId_category(item.getCategory().getId());
			models.add(p);
		}
		return models;
	}

	@Override
	public void deleteById(long id) {
		proRep.delete(id);

	}

}
