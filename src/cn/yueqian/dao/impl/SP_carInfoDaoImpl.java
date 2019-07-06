package cn.yueqian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.yueqian.dao.SP_carInfoDao;
import cn.yueqian.javabean.SP_carinfo;
import cn.yueqian.util.FKJDBCUtil;

public class SP_carInfoDaoImpl implements SP_carInfoDao{
	public List<SP_carinfo> findCarInfo(String username){
		String sql = "select sp_info.id,sp_info.sp_img,sp_info.sp_info,sp_info.old_price,sp_info.new_price,sp_car.number,users.username FROM sp_info,sp_car,users where users.username=sp_car.sp_car_user and sp_car.sp_car_id=sp_info.id and users.username=?;";
		String info[] = {username};
		
		ResultSet rs = FKJDBCUtil.executeQuery(sql, info);

		List<SP_carinfo> sp_carinfo_list = new ArrayList<SP_carinfo>();
		try{
			while(rs.next()){
				SP_carinfo sp_carinfo = new SP_carinfo();
				sp_carinfo.setId(rs.getString("id"));
				sp_carinfo.setSp_img(rs.getString("sp_img"));
				sp_carinfo.setSp_info(rs.getString("sp_info"));
				sp_carinfo.setOld_price(rs.getString("old_price"));
				sp_carinfo.setNew_price(rs.getString("new_price"));
				sp_carinfo.setNumber(rs.getString("number"));
				sp_carinfo.setUsername(rs.getString("username"));
				
				sp_carinfo_list.add(sp_carinfo);
			}
			for(SP_carinfo sp_carinfo : sp_carinfo_list){
				System.out.println(sp_carinfo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			FKJDBCUtil.close(FKJDBCUtil.getCt(), FKJDBCUtil.getPs(), rs);
		}
		
		return sp_carinfo_list;
	}
}
