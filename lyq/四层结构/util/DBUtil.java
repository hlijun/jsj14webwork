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
		//通过反射机制动态的引入应用的数据库的驱动,获取连接对象
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
	//关闭对象
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
