package cn.zk.jsj14.wsgwpt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class cs {

	/**
	 * @param <declared>
	 * @param args
	 */
	public static <declared> void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// �������ݿ�
		conn = DBUtil.getConnection();
		if (conn == null) {
			throw new Exception("���ݿ����Ӳ��ɹ���");
		}
		String userName = "��ʳ";
		String sqlQuery = "Select * from goods_imformation where goods_name like '%"+userName+"%'";
		ps = conn.prepareStatement(sqlQuery);   
		 rs = ps.executeQuery();
		   
			
				while(rs.next()){
					String b =rs.getString("goods_name");
					System.out.println(b);
				}
			
		
	  System.out.println("userName");
		
}
	}


