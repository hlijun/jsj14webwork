package cn.zk.jsj14.wsgwpt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import cn.zk.jsj14.wsgwpt.domain.User;
import cn.zk.jsj14.wsgwpt.util.DBUtil;

public class LoginDao {
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * �÷���Ϊ��ͨ�����û���������ȥ��ȡ���ݿ�
	 * ������ص�userΪ�գ���ʾ���û����벻��
	 * ������ص�user��Ϊ�գ���ʾ���û�������ȷ
	 */
	public User getUserByName(User user) throws Exception {
	User newUser = new User();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// �������ݿ�
		conn = DBUtil.getConnection();

		if (conn == null) {
			throw new Exception("���ݿ����Ӳ��ɹ���");
		}
		String sqlQuery = "Select user_name,user_pwd from user where user_name = ? && user_pwd = ?";
		
		ps = conn.prepareStatement(sqlQuery);

		ps.setString(1, user.getUser_name());
		ps.setString(2, user.getUser_pwd());

		rs = ps.executeQuery();
	   
		boolean result = rs.next();

		if (result == false) {
			return newUser;
		}else{
			
		String userName = rs.getString("user_name");
		String userPassword = rs.getString("user_pwd");
		newUser.setUser_name(userName);
		newUser.setUser_pwd(userPassword);
		return newUser;
		}

	}

	public boolean CkName(String userName) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// �������ݿ�
		conn = DBUtil.getConnection();
		if (conn == null) {
			throw new Exception("���ݿ����Ӳ��ɹ���");
		}
		String sqlQuery = "Select * from user where user_name = '"+userName+"'";
		ps = conn.prepareStatement(sqlQuery);   
		 rs = ps.executeQuery();
		   
			boolean result = rs.next();
			boolean a =false;

			if (result == false) {
				a=false;
			}else{

			a=true ;
			}
			return a;
	}
}

