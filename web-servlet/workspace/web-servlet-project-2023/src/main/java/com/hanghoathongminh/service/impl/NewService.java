package com.hanghoathongminh.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.hanghoathongminh.dao.INewDAO;
import com.hanghoathongminh.model.NewModel;
import com.hanghoathongminh.service.INewservice;

public class NewService implements INewservice {

	@Inject
	private INewDAO newDAO;

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		return newDAO.findByCategoryId(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		newModel.setCreatedBy("");
		Long newId = newDAO.save(newModel);
		return newDAO.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updateNew.setModifiedBy("");
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			//1.delete comment (fk newid)
			//2.delete news
			newDAO.delete(id);
		}
	}

	@Override
	public List<NewModel> findAll(Integer offset, Integer limit) {
		return newDAO.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}

}
