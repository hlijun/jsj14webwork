package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.UserDaoImpl;
import cn.zk.jsj14.wsgwpt.domain.User;

public class UserServiceImpl {
	//����һ��Dao����
		UserDaoImpl userDao = new UserDaoImpl();
		
		
		//�û�ע�ᣨ����û���
		public void addUser(User user){
			try {
				userDao.addUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//�޸��û���Ϣ
				public void updateUser(User user){
					try {
						userDao.updateUser(user);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				//�޸��û�����
				public void updateUserpwd(User user){
					try {
						userDao.updateUserpwd(user);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

}
