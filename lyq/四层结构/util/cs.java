package cn.zk.jsj14.wsgwpt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cs {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		
		ResultSet rs = null;

		// 连接数据库
		conn = DBUtil.getConnection();

		if (conn == null)
			System.out.println("dfd");

		String sql = "insert into user values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,"adfghjkt");
		pstmt.setString(2,"123456");
		pstmt.setString(3,"asdfgh");
		pstmt.setString(4,"123456");
		pstmt.setString(5,"asdfg");
		pstmt.executeUpdate();



		
	  System.out.println("userName");
		
	}

}
