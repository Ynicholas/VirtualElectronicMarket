package cn.yueqian.dao;

import java.util.List;

import cn.yueqian.javabean.SP_carinfo;

public interface SP_carInfoDao {
	List<SP_carinfo> findCarInfo(String username);
}
