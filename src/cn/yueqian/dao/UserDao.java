package cn.yueqian.dao;

public interface UserDao {
	//1.����һ������Username�ķ���
	void save(String username,String password);
	//2.����һ����������boolean�ж��û��Ƿ�ע��
	boolean findByUsername(String username);
	//3.����һ������������һ��boolean,�ж��û��Ƿ��¼�ɹ�
	boolean LoginUsername(String username,String password);
}
