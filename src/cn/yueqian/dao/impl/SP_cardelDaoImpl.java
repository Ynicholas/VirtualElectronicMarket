package cn.yueqian.dao.impl;

import cn.yueqian.dao.SP_cardelDao;
import cn.yueqian.util.FKJDBCUtil;

public class SP_cardelDaoImpl implements SP_cardelDao{
	public int SP_cardel(String id,String username){
		
		String sql = "delete from sp_car where sp_car_user = ? and sp_car_id = ?;";
		String info[] = {username,id};
		
		return FKJDBCUtil.executeUpdate(sql, info);
	}
}
