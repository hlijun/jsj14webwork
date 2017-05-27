package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Shop;
import cn.zk.jsj14.wsgwpt.service.ShopService;

public class CkShop1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//���jspҳ�����
		String shop_name = (String)request.getParameter("name");
		String method = (String)request.getParameter("method");
		//����ҵ���߼�
		ShopService ga = new ShopService();
		 Shop shop = ga.selectShop(shop_name);
		 request.setAttribute("shop",shop);
		//��תҳ��
		RequestDispatcher rd = null;
	    if(method.equals("cx"))
	    {
			rd = request.getRequestDispatcher("/yyscxshopgo.jsp");
	    }else{
	    	rd = request.getRequestDispatcher("/yysupdateshopgo.jsp");
	    }
		
		rd.forward(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
