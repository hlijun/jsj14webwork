package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.OrderDao;
import cn.zk.jsj14.wsgwpt.domain.Order;

public class OderService {
	//创建一个Dao对象
		OrderDao OrderDao = new OrderDao();
		
		
		//添加订单
		public void addOrder(Order order){
			try {
				OrderDao.addOrder(order);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//修改订单
				public void updateOrder(Order order){
					try {
						OrderDao.updateOrder(order);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	    //删除订单
			public void deldetGoods(Order order){
						try {
							OrderDao.deleteOrder(order);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
		
	  //查询订单
			public Order CXOrder(String orderId) {
				try {
				return	OrderDao.CXOrder(orderId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
				
			}
			
}