package cn.yueqian.dao;

public interface UserDao {
	//1.定义一个保存Username的方法
	void save(String username,String password);
	//2.定义一个方法返回boolean判断用户是否被注册
	boolean findByUsername(String username);
	//3.定义一个方法，返回一个boolean,判断用户是否登录成功
	boolean LoginUsername(String username,String password);
}
