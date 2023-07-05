package com.hanghoathongminh.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.hanghoathongminh.dao.impl.CategoryDAO;
import com.hanghoathongminh.model.CategoryModel;
import com.hanghoathongminh.service.ICategoryService;

public class CategoryService implements ICategoryService {

	@Inject
	private CategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {

		return categoryDAO.findAll();
	}

}
