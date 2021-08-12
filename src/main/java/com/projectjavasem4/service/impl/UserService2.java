package com.projectjavasem4.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.projectjavasem4.dto.UsertDTO2;
import com.projectjavasem4.entities.UserEntity;
import com.projectjavasem4.repository.AbtracsRepository2;
import com.projectjavasem4.service.IUserService2;

@Service
public class UserService2 implements IUserService2 {

	/*
	 * @Autowired private UserRepository Rep;
	 */
	
	@Autowired
	private JpaRepository<UserEntity, Long> AbRep;
	
	 private AbtracsRepository2<UserEntity> AbRep2;
	 
	
	/*
	 * @Autowired private AbtracsRepository2<UserEntity> AbRep2;
	 */
	
	/*
	 * @Override public List<UsertDTO2> getAll() { List<UsertDTO2> models = new
	 * ArrayList<>(); List<UserEntity> entities = Rep.findAll(); for (UserEntity
	 * item : entities) { UsertDTO2 p = new ModelMapper().map(item,
	 * UsertDTO2.class);
	 * 
	 * models.add(p); } return models; }
	 */
	
	@Override
	public List<UsertDTO2> getAll() {
		List<UsertDTO2> models = new ArrayList<>();
		List<UserEntity> entities =  AbRep2.findAll();
		for (UserEntity item : entities) {
			UsertDTO2 p = new ModelMapper().map(item, UsertDTO2.class);
			
			models.add(p);
		}
		return models;
	}

	

}
