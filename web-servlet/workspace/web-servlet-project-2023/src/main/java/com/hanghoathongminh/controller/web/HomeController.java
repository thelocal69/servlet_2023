package com.hanghoathongminh.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanghoathongminh.service.ICategoryService;

@WebServlet(urlPatterns = { "/home-user" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService iCategoryService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "/views/web/home.jsp";
		req.setAttribute("categories", iCategoryService.findAll());
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
