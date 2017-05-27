package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Shop;
import cn.zk.jsj14.wsgwpt.domain.User;
import cn.zk.jsj14.wsgwpt.service.ShopService;
import cn.zk.jsj14.wsgwpt.service.UserServiceImpl;

public class UpdateShopServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//���jspҳ�����
		String shopname = (String)request.getParameter("name");
		String shopusername =(String) request.getParameter("username");
		String shoptel =(String) request.getParameter("tel");
		String shopaddress = (String) request.getParameter("address");
		String method = (String)request.getParameter("method");
		//��������γ�һ��user�����Ա��ں��洫�ݲ���ʹ��
		Shop shop = new Shop();
		shop.setShop_name(shopname);
		shop.setShop_username(shopusername);
		shop.setShop_usertel(shoptel);
		shop.setShop_useraddress(shopaddress);
		//����ҵ���߼�
				ShopService ua = new ShopService();
				ua.updateShop(shop);
				//��תҳ��
				RequestDispatcher rd = null;
				if(method.equals("shop")){
					rd = request.getRequestDispatcher("/shopglzx.jsp");
				}else{
					rd = request.getRequestDispatcher("/yysglzx.jsp");
				}
				rd.forward(request, response);	
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
