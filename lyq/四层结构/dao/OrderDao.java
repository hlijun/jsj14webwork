package cn.zk.jsj14.wsgwpt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.domain.Order;
import cn.zk.jsj14.wsgwpt.util.DBUtil;

public class OrderDao {
	//添加订单
	public void addOrder(Order order) throws SQLException{
		// 连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		String sql = "insert into good values(?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,order.getOrder_id());
		pstmt.setString(2,order.getGoods_id());
		pstmt.setString(3,order.getOrder_amount());
		pstmt.setString(4,order.getOrder_state());
		pstmt.setDouble(5,order.getOrder_price());
		pstmt.setString(6,order.getUser_name());
		pstmt.setString(7,order.getUser_tel());
		pstmt.setString(6,order.getUser_address());
		pstmt.executeUpdate();
	}
	//修改订单
		public void updateOrder(Order order) throws SQLException{
			// 连接数据库
			Connection conn = null;
			conn = DBUtil.getConnection();
			String sql = "update Order set goods_id=?,order_amount=?,order_state=? ,order_price? ,user_name?,user_tel?,user_address?where order_id ='"+order.getOrder_id()+"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,order.getGoods_id());
			pstmt.setString(2,order.getOrder_amount());
			pstmt.setString(3,order.getOrder_state());
			pstmt.setDouble(4,order.getOrder_price());
			pstmt.setString(5,order.getUser_name());
			pstmt.setString(6,order.getUser_tel());
			pstmt.setString(7,order.getUser_address());
			pstmt.executeUpdate();
		}
		//删除订单
				public void deleteOrder(Order order) throws SQLException{
					// 连接数据库
					Connection conn = null;
					PreparedStatement ps = null;
					conn = DBUtil.getConnection();
					String sql = "delete Order where order_id ='"+order.getOrder_id()+"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
				}
		//查询订单
				public Order CXOrder(String orderId) throws SQLException {
					// 连接数据库
					Connection conn = null;
					ResultSet rs = null;
					conn = DBUtil.getConnection();
					String sql = "select * from Order where order_name ='"+orderId+"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					String goodsid="";
					String orderamount= null ;
					String orderstate="";
					Double orderprice=null;
					String username= "";
					String usertel="";
					String useraddress=null;
					rs = pstmt.executeQuery();
					while(rs.next()) {
					 goodsid = rs.getString("goods_id");
					 orderamount = rs.getString("order_amount");
					 orderstate = rs.getString("order_state");
					 orderprice = rs.getDouble("order_price");
					 username = rs.getString("user_name");
					 usertel = rs.getString("user_tel");
					 useraddress = rs.getString("user_address");
					}
					Order order= new Order();
					order.setOrder_id(orderId);
					order.setGoods_id(goodsid);
					order.setOrder_amount(orderamount);
					order.setOrder_state(orderstate);
					order.setOrder_price(orderprice);
					order.setUser_name(username);
					order.setUser_tel(usertel);
					order.setUser_address(useraddress);
					return order;
				}
}