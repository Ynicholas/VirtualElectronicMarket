package cn.yueqian.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.dao.SP_cardelDao;
import cn.yueqian.dao.impl.SP_cardelDaoImpl;

public class SP_cardelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username");
		//假装有sp_id传入
		String id = request.getParameter("id");
		System.out.println(username+id);
		SP_cardelDao sp_cardelDao = new SP_cardelDaoImpl();
		int flag = sp_cardelDao.SP_cardel(id, username);
		System.out.println(flag);
		request.getRequestDispatcher("../servlet/SP_carInfoServlet").forward(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
