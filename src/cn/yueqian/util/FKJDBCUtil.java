package cn.yueqian.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * JDBC:java代码数据库连接，通用的，oracle mysql sqlserver
 * 1.导入数据库jar包，mysql jar包，如果是oracle导入oracle jar包
 * 2.将mysql jar包放入lib文件夹下面
 * 3.add to build path
 * 4.完成java代码编写
 */
public class FKJDBCUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";//驱动包的位置
	
	private static final String URL = "jdbc:mysql://localhost:3306/sp_db?useUnicode=true&characterEncoding=utf-8";

	private static final String USER = "root";//数据库的用户名
	
	private static final String PASSWORD = "123456";//数据库密码，如果没有密码就用："";
	
	private static Connection ct = null;//加载驱动的对象
	
	private static PreparedStatement ps = null; //发送sql语句的对象
	
	private static ResultSet rs =null;//返回的结果
	
	//1.加载驱动，因为我们的数据库驱动只需要加载一次，故可以将加载驱动的代码放到静态代码块中
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//2.获得连接
	public static Connection getConnection(){
		try{
			ct = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
	
	//3.得到发送sql语句对象statement
	
	public static ResultSet executeQuery(String  sql, String[] info){
		//得到连接
		ct = getConnection();
		try{
			//得到ps对象
			ps = (PreparedStatement) ct.prepareStatement(sql);
			//处理占位符的问题
			if (info != null){
				for (int i = 0; i < info.length; i++) {
					//将占位符设置到sql语句中
					ps.setString(1 + i, info[i]);
				}
			}
			//4.发送sql语句，这时发生查询的sql语句
			rs = ps.executeQuery();
			//5.返回操作结果（ResultSet） 
			return rs;
			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//注意:查询方法的资源不可以在这关闭，因为我们还要对查询到的结果进行操作
		
		return null;
	} 
	
	//编写一个方法可以完成增删改的操作
	public static int executeUpdate(String  sql, String[] info){
		//得到连接
		ct = getConnection();
		try{
			//得到ps对象
			ps = (PreparedStatement) ct.prepareStatement(sql);
			//处理占位符的问题
			if (info != null){
				for (int i = 0; i < info.length; i++) {
					//将占位符设置到sql语句中
					ps.setString(1 + i, info[i]);
				}
			}
			//4.发送sql语句，这时发生查询的sql语句 
			int row = ps.executeUpdate();
			//5.返回操作结果（ResultSet） 
			
			if(row > 0){
				System.out.println("操作成功，作用了"+row+"条记录！");
			}else{
				System.out.println("操作失败！");
			}
			return row;
			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(ct,ps,rs);
		}
		
		return 0;
	} 
	
	
	//7.关闭资源
	public static void close(Connection ct, PreparedStatement ps, ResultSet rs){
		//关闭资源原则:先打开，后关闭
		try{
			if (rs != null){
				rs.close();
			}
			rs = null;
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			if (ps != null){
				ps.close();
			}
			ps = null;
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			if (ct != null){
				ct.close();
			}
			ct = null;
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//编写两个方法可以返回ps,ct
	public static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
}
