package com.hanghoathongminh.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanghoathongminh.constant.SystemConstant;
import com.hanghoathongminh.model.NewModel;
import com.hanghoathongminh.service.INewservice;
import com.hanghoathongminh.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewservice newservice;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModel model = FormUtil.toModel(NewModel.class, req);
		Integer offset = (model.getPage()-1) * model.getMaxPageItem();
		model.setListModel(newservice.findAll(offset, model.getMaxPageItem()));
		model.setTotalItem(newservice.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getMaxPageItem()));
		req.setAttribute(SystemConstant.MODEL, model);
		String url = "/views/admin/new/list.jsp";
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
