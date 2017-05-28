package cn.zk.jsj14.wsgwpt.service;

import cn.zk.jsj14.wsgwpt.dao.LoginDao;
import cn.zk.jsj14.wsgwpt.domain.User;


public class LoginService {
	

	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * 该方法检测用户名和密码，并返回一个boolean对象，
	 * 如果返回true表示用户名和密码存在
	 * 如果返回false表示不存在
	 */
    public boolean checkUserNameAndPassword(User user) throws Exception{
    	
    	LoginDao ld = new LoginDao();
    	
    	boolean result = false;
    	User newUser = new User();
    	
    	newUser = ld.getUserByName(user);
    	
    	//如果返回值不为空，表示可以得到一个用户名和密码相匹配的值
    	if( newUser.getUser_name() != null){
    		result = true;
    	}
    	
    	return result;
    }
    
}
