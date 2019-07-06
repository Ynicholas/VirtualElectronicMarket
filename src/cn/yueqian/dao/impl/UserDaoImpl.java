package cn.yueqian.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.yueqian.dao.UserDao;
import cn.yueqian.util.FKJDBCUtil;
	public class UserDaoImpl implements UserDao{
		
		public void save(String username,String password){
			String sql = "insert ignore into users(username,password)values(?,?)";
			String info[] = {username,password};
			FKJDBCUtil.executeUpdate(sql, info);
		}
		
		public boolean findByUsername(String username){
			ResultSet rs = null;
			try{
				String sql = "select * from users where username = ?";
				String info[] = {username};
				rs  = FKJDBCUtil.executeQuery(sql, info);
				if(rs.next()){
					return false;
				}else{
					return true;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				FKJDBCUtil.close(FKJDBCUtil.getCt(), FKJDBCUtil.getPs(), rs);
			}
			
			return false;
		}
		
		public boolean LoginUsername(String username,String password){
			//注意：在作用户登录的时候要考虑数据库注入漏洞,万能密码
			//不能，讲用户名与密码去数据库查询
			//能，讲用户名到数据库去查询，查询返回密码，再与password比较
			String sql = "select password from users where username = ?";
			String info[] = {username};
			ResultSet rs = FKJDBCUtil.executeQuery(sql, info);
			String password2 = null;
			boolean login = false;
			try{
				if(rs.next()){
					password2 = rs.getString("password");
					if(password2.equals(password)){
						System.out.println("用户登录成功!");
						login = true;
					}else{
						System.out.println("密码错误!");
					}
					
				}else{
					System.out.println("用户不存在！");
				}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				FKJDBCUtil.close(FKJDBCUtil.getCt(), FKJDBCUtil.getPs(), rs);
			}
			return login;
		}
}
