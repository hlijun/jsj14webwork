package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.UserDaoImpl;
import cn.zk.jsj14.wsgwpt.domain.User;

public class UserServiceImpl {
	//创建一个Dao对象
		UserDaoImpl userDao = new UserDaoImpl();
		
		
		//用户注册（添加用户）
		public void addUser(User user){
			try {
				userDao.addUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//修改用户信息
				public void updateUser(User user){
					try {
						userDao.updateUser(user);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				//修改用户密码
				public void updateUserpwd(User user){
					try {
						userDao.updateUserpwd(user);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

}
