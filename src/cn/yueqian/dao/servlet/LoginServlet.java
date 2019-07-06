package cn.yueqian.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yueqian.dao.UserDao;
import cn.yueqian.dao.impl.UserDaoImpl;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//以utf-8编码接受数据
		request.setCharacterEncoding("utf-8");
		//将数据utf-8响应
		response.setCharacterEncoding("utf-8");
		//通知浏览器，以utf-8编码打开数据
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter outPrintWriter = response.getWriter();

		
		//得到用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao u_dao = new UserDaoImpl();
		boolean login = u_dao.LoginUsername(username, password);
		
		//jsp四大作用域:
		/*
		 * 1.page:当前页面-数据仅仅在当前页面可以访问
		 * 2.request:当次请求
		 * 3.session:当次对话,如果浏览器没有关闭，则都可以发访问到，保存在服务器端
		 * 4.application：整个项目
		 */
		
		if(login){
			//将登陆成功的用户名存放到session中
			HttpSession session = request.getSession();//实例化一个session对象
			session.setAttribute("username", username);//讲登陆成功的用户名保存到session中
			response.sendRedirect("../servlet/IndexServlet");
		}else{
			response.sendRedirect("../Login.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


}
