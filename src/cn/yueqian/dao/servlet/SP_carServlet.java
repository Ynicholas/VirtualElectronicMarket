package cn.yueqian.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.dao.SP_carDao;
import cn.yueqian.dao.impl.SP_carDaoImpl;

public class SP_carServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sp_car_id = request.getParameter("id");
		String number = request.getParameter("number");
		String sp_car_user = request.getSession().getAttribute("username")+"";
		
		SP_carDao sp_carDao = new SP_carDaoImpl();
		System.out.println("用户名："+sp_car_user+",数量"+number+",id=="+sp_car_id);
		if(!sp_car_user.equals("null")){
			boolean ac = sp_carDao.findSP_car(sp_car_id, sp_car_user);
			System.out.println(number);
			if(ac){	
				if(number==null){
					
				}else{
					sp_carDao.updateSP_car(sp_car_id,number,sp_car_user);
				}
			}else{
				if(number==null){
					
				}else{
					sp_carDao.addSP_car(sp_car_id, sp_car_user, number);
				}
			}
			request.getRequestDispatcher("../servlet/SP_carInfoServlet").forward(request,response);
		}else{
			
			response.sendRedirect("../Login.jsp");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
