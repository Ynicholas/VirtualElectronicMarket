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
		//��utf-8�����������
		request.setCharacterEncoding("utf-8");
		//������utf-8��Ӧ
		response.setCharacterEncoding("utf-8");
		//֪ͨ���������utf-8���������
		response.setContentType("text/html;charset=utf-8");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("�û����ǣ�"+username+";�����ǣ�"+password);
		UserDao userDao = new UserDaoImpl();
		userDao.save(username,password);
		
		//ת��
		//request.getRequestDispatcher("../index.jsp").forward(request,response);
		
		//�ض���
		response.sendRedirect("../servlet/IndexServlet");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response); 
	}

}