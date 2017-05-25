package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Shopping_cart;
import cn.zk.jsj14.wsgwpt.service.ShopcartService;

public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//���jspҳ�����
		String id = (String)request.getParameter("goods_id");
		//����ҵ���߼�
				ShopcartService ga = new ShopcartService();
				Shopping_cart shopcart = ga.buyGood(id);
				 request.setAttribute("shopcart", shopcart);
				//��תҳ��
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/tjdd.jsp");
				rd.forward(request, response);	
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
