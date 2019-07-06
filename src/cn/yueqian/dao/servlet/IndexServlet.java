package cn.yueqian.dao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yueqian.dao.SP_infoDao;
import cn.yueqian.dao.impl.SP_infoDaoImpl;
import cn.yueqian.javabean.SP_info;

public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String type = request.getParameter("type");
		String info_sous = request.getParameter("info_sous");
		String id = request.getParameter("id");
		
		System.out.println("类型是:"+type+"，搜索信息:"+info_sous+",id="+id);
		
		SP_infoDao sp_info = new SP_infoDaoImpl();
		
		List<SP_info> sp_info_list = null;
		if(id!=null){
			sp_info_list = sp_info.getSP_infoList(null, null,id);
			
			request.setAttribute("sp_info_list", sp_info_list);
			request.getRequestDispatcher("../Sp_xiangqing.jsp").forward(request,response);
		}else{
			//转发到jsp页面
			sp_info_list = sp_info.getSP_infoList(type, info_sous,null);
			
			request.setAttribute("sp_info_list", sp_info_list);
			request.getRequestDispatcher("../index.jsp").forward(request,response);
		}
		
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}



}
