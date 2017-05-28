package cn.zk.jsj14.wsgwpt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;
import cn.zk.jsj14.wsgwpt.util.DBUtil;

public class GoodsDao {
	//添加商品
	public void addGoods(Goods_imformation goods) throws SQLException{
		// 连接数据库
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBUtil.getConnection();
		String sql = "insert into good values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,goods.getGoods_id());
		pstmt.setString(2,goods.getGoods_name());
		pstmt.setString(3,goods.getGoods_amount());
		pstmt.setString(4,goods.getGoods_type());
		pstmt.setDouble(5,goods.getGood_price());
		pstmt.executeUpdate();
	}
	//修改商品
		public void updateGoods(Goods_imformation goods) throws SQLException{
			// 连接数据库
			Connection conn = null;
			conn = DBUtil.getConnection();
			String sql = "update goods_information set goods_name=?,goods_amount=?,goods_type=? ,good_price? where goods_id ='"+goods.getGoods_id()+"'";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,goods.getGoods_name());
			pstmt.setString(2,goods.getGoods_amount());
			pstmt.setString(3,goods.getGoods_type());
			pstmt.setDouble(4,goods.getGood_price());
			pstmt.executeUpdate();
		}
		//删除商品
				public void deleteGoods(Goods_imformation goods) throws SQLException{
					// 连接数据库
					Connection conn = null;
					PreparedStatement ps = null;
					conn = DBUtil.getConnection();
					String sql = "delete goods_information where goods_name ='"+goods.getGoods_name()+"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
				}
		//查询商品信息
				public Goods_imformation CXGoods(String goodsId) throws SQLException {
					// 连接数据库
					Connection conn = null;
					ResultSet rs = null;
					conn = DBUtil.getConnection();
					String sql = "select * from goods_information where goods_name ='"+goodsId+"'";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					String goodsname="";
					Double goodsamount= null ;
					String goodstate="";
					Double goodsprice=null;
					Double thingamount= null ;
					rs = pstmt.executeQuery();
					while(rs.next()) {
					 goodsname = rs.getString("goods_name");
					 goodsamount = rs.getDouble("goods_amount");
					 goodstate = rs.getString("goods_type");
					 goodsprice = rs.getDouble("good_price");
					 thingamount = 1.0;
					}
					Goods_imformation good= new Goods_imformation();
					good.setGoods_id(goodsId);
					return good;
				}
}
