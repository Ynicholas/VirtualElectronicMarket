package cn.yueqian.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * JDBC:java�������ݿ����ӣ�ͨ�õģ�oracle mysql sqlserver
 * 1.�������ݿ�jar����mysql jar���������oracle����oracle jar��
 * 2.��mysql jar������lib�ļ�������
 * 3.add to build path
 * 4.���java�����д
 */
public class FKJDBCUtil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";//��������λ��
	
	private static final String URL = "jdbc:mysql://localhost:3306/sp_db?useUnicode=true&characterEncoding=utf-8";

	private static final String USER = "root";//���ݿ���û���
	
	private static final String PASSWORD = "123456";//���ݿ����룬���û��������ã�"";
	
	private static Connection ct = null;//���������Ķ���
	
	private static PreparedStatement ps = null; //����sql���Ķ���
	
	private static ResultSet rs =null;//���صĽ��
	
	//1.������������Ϊ���ǵ����ݿ�����ֻ��Ҫ����һ�Σ��ʿ��Խ����������Ĵ���ŵ���̬�������
	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//2.�������
	public static Connection getConnection(){
		try{
			ct = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ct;
	}
	
	
	//3.�õ�����sql������statement
	
	public static ResultSet executeQuery(String  sql, String[] info){
		//�õ�����
		ct = getConnection();
		try{
			//�õ�ps����
			ps = (PreparedStatement) ct.prepareStatement(sql);
			//����ռλ��������
			if (info != null){
				for (int i = 0; i < info.length; i++) {
					//��ռλ�����õ�sql�����
					ps.setString(1 + i, info[i]);
				}
			}
			//4.����sql��䣬��ʱ������ѯ��sql���
			rs = ps.executeQuery();
			//5.���ز��������ResultSet�� 
			return rs;
			
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ע��:��ѯ��������Դ����������رգ���Ϊ���ǻ�Ҫ�Բ�ѯ���Ľ�����в���
		
		return null;
	} 
	
	//��дһ���������������ɾ�ĵĲ���
	public static int executeUpdate(String  sql, String[] info){
		//�õ�����
		ct = getConnection();
		try{
			//�õ�ps����
			ps = (PreparedStatement) ct.prepareStatement(sql);
			//����ռλ��������
			if (info != null){
				for (int i = 0; i < info.length; i++) {
					//��ռλ�����õ�sql�����
					ps.setString(1 + i, info[i]);
				}
			}
			//4.����sql��䣬��ʱ������ѯ��sql��� 
			int row = ps.executeUpdate();
			//5.���ز��������ResultSet�� 
			
			if(row > 0){
				System.out.println("�����ɹ���������"+row+"����¼��");
			}else{
				System.out.println("����ʧ�ܣ�");
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
	
	
	//7.�ر���Դ
	public static void close(Connection ct, PreparedStatement ps, ResultSet rs){
		//�ر���Դԭ��:�ȴ򿪣���ر�
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
	
	//��д�����������Է���ps,ct
	public static Connection getCt(){
		return ct;
	}
	public static PreparedStatement getPs(){
		return ps;
	}
}
