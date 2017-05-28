package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.GoodsDao;
import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;

public class GoodsService {
	//创建一个Dao对象
		GoodsDao GoodsDao = new GoodsDao();
		
		
		//添加商品
		public void addGoods(Goods_imformation good){
			try {
				GoodsDao.addGoods(good);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//修改商品信息
				public void updateGoods(Goods_imformation good){
					try {
						GoodsDao.updateGoods(good);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
	    //删除商品
			public void deldetGoods(Goods_imformation good){
						try {
							GoodsDao.deleteGoods(good);
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					
		
	  //查询商品
			public Goods_imformation CXGoods(String goodsId) {
				try {
				return	GoodsDao.CXGoods(goodsId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
				
			}
			
}
