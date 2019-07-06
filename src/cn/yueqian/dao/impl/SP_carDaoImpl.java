package cn.yueqian.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yueqian.dao.SP_carDao;
import cn.yueqian.util.FKJDBCUtil;

public class SP_carDaoImpl implements SP_carDao{
	public int addSP_car(String sp_id,String username,String number){
		
		String sql = "insert into sp_car (sp_car_id,number,sp_car_user)values(?,?,?);";
		String info[] = {sp_id,number,username};
		
		return FKJDBCUtil.executeUpdate(sql, info);
	}
	
	public boolean findSP_car(String sp_car_id,String sp_car_user){
		String sql= "select * from sp_car where sp_car_id = ? and sp_car_user =?";
		String info[] = {sp_car_id,sp_car_user};
		ResultSet rs= FKJDBCUtil.executeQuery(sql, info);
		boolean flag = false;
		try{
			if(rs.next()){
				flag = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			FKJDBCUtil.close(FKJDBCUtil.getCt(),FKJDBCUtil.getPs(),rs);
		}
		return flag;
	}
	
	public int updateSP_car(String sp_car_id,String number,String sp_car_user){
		String sql = "update sp_car set number=number+? where sp_car_id=? and sp_car_user=?";
		String info[] = {number,sp_car_id,sp_car_user};
		return FKJDBCUtil.executeUpdate(sql, info);
	}
}
