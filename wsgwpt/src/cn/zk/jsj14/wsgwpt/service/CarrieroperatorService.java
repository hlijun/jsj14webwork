package cn.zk.jsj14.wsgwpt.service;

import java.sql.SQLException;

import cn.zk.jsj14.wsgwpt.dao.CarrieroperatorDao;
import cn.zk.jsj14.wsgwpt.domain.Carrieroperator;
import cn.zk.jsj14.wsgwpt.domain.User;

public class CarrieroperatorService {
	CarrieroperatorDao ca = new CarrieroperatorDao();
	
	public boolean checkNameAndPassword(Carrieroperator xiaoer) throws Exception {
		boolean result = false;
		Carrieroperator newXiaoer = new Carrieroperator();
    	newXiaoer = ca.checkNameAndPassword(xiaoer);	
    	//�������ֵ��Ϊ�գ���ʾ���Եõ�һ���û�����������ƥ���ֵ
    	if( newXiaoer.getCarrieroperator_name() != null){
    		result = true;
    	}
		return result;
	}
//�޸�����
	public void updatePwd(Carrieroperator xiaoer) {
		try {
			ca.updatePwd(xiaoer);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
