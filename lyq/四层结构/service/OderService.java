package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.OrderDao;
import cn.zk.jsj14.wsgwpt.domain.Order;

public class OderService {
	//����һ��Dao����
		OrderDao OrderDao = new OrderDao();
		
		
		//��Ӷ���
		public void addOrder(Order order){
			try {
				OrderDao.addOrder(order);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//�޸Ķ���
				public void updateOrder(Order order){
					try {
						OrderDao.updateOrder(order);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	    //ɾ������
			public void deldetGoods(Order order){
						try {
							OrderDao.deleteOrder(order);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
		
	  //��ѯ����
			public Order CXOrder(String orderId) {
				try {
				return	OrderDao.CXOrder(orderId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
				
			}
			
}