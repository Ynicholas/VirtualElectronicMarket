package cn.yueqian.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.dao.UserDao;
import cn.yueqian.dao.impl.UserDaoImpl;

public class UserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//以utf-8编码接受数据
		request.setCharacterEncoding("utf-8");
		//将数据utf-8响应
		response.setCharacterEncoding("utf-8");
		//通知浏览器，以utf-8编码打开数据
		response.setContentType("text/html;charset=utf-8");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("用户名是："+username+";密码是："+password);
		UserDao userDao = new UserDaoImpl();
		userDao.save(username,password);
		
		//转发
		//request.getRequestDispatcher("../index.jsp").forward(request,response);
		
		//重定向
		response.sendRedirect("../servlet/IndexServlet");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response); 
	}

}