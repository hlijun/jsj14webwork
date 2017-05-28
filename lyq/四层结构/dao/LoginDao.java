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
	 * 该方法为：通过用用户名和密码去读取数据库
	 * 如果返回的user为空，表示该用户密码不对
	 * 如果返回的user不为空，表示该用户密码正确
	 */
	public User getUserByName(User user) throws Exception {
	User newUser = new User();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// 连接数据库
		conn = DBUtil.getConnection();

		if (conn == null) {
			throw new Exception("数据库连接不成功！");
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
}

