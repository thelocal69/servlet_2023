package com.hanghoathongminh.dao.impl;

import java.util.List;

import com.hanghoathongminh.dao.ICategoryDAO;
import com.hanghoathongminh.mapper.CategoryMapper;
import com.hanghoathongminh.model.CategoryModel;

public class CategoryDAO extends AbstactDAO<CategoryModel> implements ICategoryDAO{


	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

}
