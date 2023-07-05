package com.hanghoathongminh.dao;

import java.util.List;

import com.hanghoathongminh.model.CategoryModel;


public interface ICategoryDAO{
	List<CategoryModel> findAll();
	
}
