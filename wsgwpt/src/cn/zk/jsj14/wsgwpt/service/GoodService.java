package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;
import java.util.List;

import cn.zk.jsj14.wsgwpt.dao.GoodDao;
import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;

public class GoodService {
	//����һ��Dao����
	   GoodDao goodDao = new GoodDao();
			
			//�����Ʒ
			public void addGood(Goods_imformation good){
				try {
					goodDao.addGood(good);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
            //������Ʒ
			public List<Goods_imformation> searchGood(String name) {
				try {
					return goodDao.searchGood(name);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			public Goods_imformation buyGoods(String id) {
				try {
					return goodDao.buyGood(id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			public Goods_imformation ckGood(String goodid) {
				try {
					return goodDao.ckGood(goodid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			}
			public void updateGood(Goods_imformation good) {
				try {
					goodDao.updateGood(good);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			public void delGood(String goodid) {
				try {
					goodDao.delGood(goodid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			

}
