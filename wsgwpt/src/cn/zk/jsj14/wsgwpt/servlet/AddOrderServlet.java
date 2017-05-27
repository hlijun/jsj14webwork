package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Order;
import cn.zk.jsj14.wsgwpt.service.OrderService;
import cn.zk.jsj14.wsgwpt.service.ShopcartService;

public class AddOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
				request.setCharacterEncoding("utf-8");
				//�趨��������ʽ
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				//���jspҳ�����
				String order_id = (String)request.getParameter("order_id");
				String goods_id = (String)request.getParameter("goods_id");
				String amount = (String)request.getParameter("goods_amount");
				Double order_amount = Double.parseDouble(amount);
				String order_state = (String)request.getParameter("order_state");
				String goodprice = (String)request.getParameter("good_price");
				Double good_price = Double.parseDouble(goodprice);
				Double order_price = order_amount * good_price ;
				String user_name = (String)request.getParameter("user_name");
				String user_tel = (String)request.getParameter("user_tel");
				String user_address = (String)request.getParameter("user_address");
				String goods_name = (String)request.getParameter("goods_name");
				//��������γ�һ�������Ա��ں��洫�ݲ���ʹ��
				Order order = new Order();
				order.setOrder_id(order_id);
				order.setGoods_id(goods_id);
				order.setOrder_amount(order_amount);
				order.setOrder_state(order_state);
				order.setUser_name(user_name);
				order.setUser_tel(user_tel);
				order.setUser_address(user_address);
				order.setOrder_price(order_price);
				order.setGoods_name(goods_name);
				//����ҵ���߼�	
				OrderService oa = new OrderService();
				oa.addOrder(order);
				ShopcartService ga = new ShopcartService();
				ga.delShopcart(goods_id);
				//��תҳ��
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/ddym.jsp");
				rd.forward(request, response);	

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
