package cn.zk.jsj14.wsgwpt.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtil {
	private static String driverName= "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/wsgwpt?useUnicode=true&characterEncoding=utf8";
	private static String userName = "root";
	private static String password = "";
	private ResultSet rs;
	private PreparedStatement pstmt;
	private  Connection conn;
	public static Connection getConnection() {
		Connection conn =null;
		try{
		//ͨ��������ƶ�̬������Ӧ�õ����ݿ������,��ȡ���Ӷ���
		Class.forName(DBUtil.driverName );
		conn = DriverManager.getConnection(DBUtil.url,DBUtil.userName,DBUtil.password);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	//�رն���
	public void close(){
		try{
			if(rs !=null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(conn != null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
