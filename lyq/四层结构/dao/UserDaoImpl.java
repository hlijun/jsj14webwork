package cn.zk.jsj14.wsgwpt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.domain.User;
import cn.zk.jsj14.wsgwpt.util.DBUtil;

public class UserDaoImpl {
	//����û�
	public void addUser(User user) throws SQLException{
		// �������ݿ�
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		String sql = "insert into user values(?,?,null,null,null)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,user.getUser_name());
		pstmt.setString(2,user.getUser_pwd());
		pstmt.executeUpdate();
	}
	//�޸��û���Ϣ
		public void updateUser(User user) throws SQLException{
			// �������ݿ�
			Connection conn = null;
			PreparedStatement ps = null;
			conn = DBUtil.getConnection();
			String sql = "update user set user_pwd=?,user_tel=?,user_truename=?,user_address=? where user_name ='"+user.getUser_name()+"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,user.getUser_pwd());
			pstmt.setString(2,user.getUser_tel());
			pstmt.setString(3,user.getUser_truename());
			pstmt.setString(4,user.getUser_address());
			pstmt.executeUpdate();
		}
		//�޸��û�����
				public void updateUserpwd(User user) throws SQLException{
					// �������ݿ�
					Connection conn = null;
					PreparedStatement ps = null;
					conn = DBUtil.getConnection();
					String sql = "update user set user_pwd=? where user_name ='"+user.getUser_name()+"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,user.getUser_pwd());
					pstmt.executeUpdate();
				}
}
