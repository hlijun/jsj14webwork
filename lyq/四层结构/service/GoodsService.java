package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.GoodsDao;
import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;

public class GoodsService {
	//����һ��Dao����
		GoodsDao GoodsDao = new GoodsDao();
		
		
		//�����Ʒ
		public void addGoods(Goods_imformation good){
			try {
				GoodsDao.addGoods(good);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//�޸���Ʒ��Ϣ
				public void updateGoods(Goods_imformation good){
					try {
						GoodsDao.updateGoods(good);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	    //ɾ����Ʒ
			public void deldetGoods(Goods_imformation good){
						try {
							GoodsDao.deleteGoods(good);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
		
	  //��ѯ��Ʒ
			public Goods_imformation CXGoods(String goodsId) {
				try {
				return	GoodsDao.CXGoods(goodsId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
				
			}
			
}
