package cn.yueqian.test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yueqian.javabean.Users;
import cn.yueqian.util.FKJDBCUtil;

public class Test1 {
	public static void main(String[] args){
		//test5();
		//test11();
		//test3();
		//test4();
		test12();
	}
	
	public static void test11(){
		try{
			String sql = "select * from users";
			
			ResultSet rs = FKJDBCUtil.executeQuery(sql, null);
			List<Users> list_users = new ArrayList<Users>();
			//对返回的结果进行操作
			while(rs.next()){
				//将数据库取得的内容，映射到user对象中
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
//				list_users.add(user);
				System.out.println(rs.getInt("id")+","+rs.getString("username")+","+rs.getString("PASSWORD"));
			}
			for(Users users : list_users){
				System.out.println(users);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void test22(){
		ResultSet rs = null;
		try{
			String sql = "select * from users where id=?";
			String info[] = {"4"};
			rs = FKJDBCUtil.executeQuery(sql, info);
			List<Users> list_users = new ArrayList<Users>();
			//对返回的结果进行操作
			while(rs.next()){
				//将数据库取得的内容，映射到user对象中
				Users user = new Users();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				list_users.add(user);
			}
			for(Users users : list_users){
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			FKJDBCUtil.close(FKJDBCUtil.getCt(), FKJDBCUtil.getPs(), rs);
		}
	}
	
	
	public static void test12(){
		try{
			String sql = "select * from users";
			
			ResultSet rs = FKJDBCUtil.executeQuery(sql, null);
			List<Users> list_users = new ArrayList<Users>();
			//对返回的结果进行操作
			while(rs.next()){
				//将数据库取得的内容，映射到user对象中
				Users user = new Users();
//				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
//				list_users.add(user);
				System.out.println(rs.getString("username")+","+rs.getString("PASSWORD"));
			}
			for(Users users : list_users){
				System.out.println(users);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void test3(){
		String sql = "insert into users(username,password)values(?,?)";
		String info[] = {"张三","aaaaaa"};
		FKJDBCUtil.executeUpdate(sql,info);
	}
	
	public static void test4(){
		String sql = "update users set password = ? where id =?";
		String info[] = {"888888","5"};
		FKJDBCUtil.executeUpdate(sql,info);
	}
	
	public static void test5(){
		String sql = "Delete from users where id =?";
		String info[] = {"4"};
		FKJDBCUtil.executeUpdate(sql,info);
	}
}
