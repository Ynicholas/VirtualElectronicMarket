package cn.yueqian.dao;

public interface SP_carDao {
	//1.添加购物车的方法
	int addSP_car(String sp_id,String username,String number);
	//2.查询用户名是否存在
	boolean findSP_car(String sp_car_id,String sp_car_user);
	//3.修改购物车信息
	int updateSP_car(String sp_car_id,String number,String sp_car_user);
}
