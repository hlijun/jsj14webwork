package cn.zk.jsj14.wsgwpt.service;

import cn.zk.jsj14.wsgwpt.dao.LoginDao;
import cn.zk.jsj14.wsgwpt.domain.User;


public class LoginService {
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 * �÷�������û��������룬������һ��boolean����
	 * �������true��ʾ�û������������
	 * �������false��ʾ������
	 */
    public boolean checkUserNameAndPassword(User user) throws Exception{
    	
    	LoginDao ld = new LoginDao();
    	
    	boolean result = false;
    	User newUser = new User();
    	newUser = ld.getUserByName(user);
    	
    	//�������ֵ��Ϊ�գ���ʾ���Եõ�һ���û�����������ƥ���ֵ
    	if( newUser.getUser_name() != null){
    		result = true;
    	}
    	
    	return result;
    }

	public boolean CkName(String userName) throws Exception {
       LoginDao ld = new LoginDao();
       boolean result = true;
       if(ld.CkName(userName) ==  true){
   		result = true;
   	}else{result = false;}
   	
   	return result;
	}
    
}
