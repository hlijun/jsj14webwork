package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.zk.jsj14.wsgwpt.domain.Order;
import cn.zk.jsj14.wsgwpt.service.GoodsService;
import cn.zk.jsj14.wsgwpt.service.OderService;

public class UpdateOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
				request.setCharacterEncoding("utf-8");
				//�趨��������ʽ
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				//���jspҳ�����
				String orderId = (String)request.getParameter("id");
				String goodsId = (String)request.getParameter("id");
				String orderAmount =(String) request.getParameter("amount");
				String orderState =(String) request.getParameter("state");
				String orderPrice = (String) request.getParameter("price");
				double goodPrice = Double.parseDouble(orderPrice);
				String userName = (String)request.getParameter("name");
				String userTel = (String)request.getParameter("tel");
				String userAddress = (String)request.getParameter("address");
				//��������γ�һ��order�����Ա��ں��洫�ݲ���ʹ��
				      Order order  = new Order();
				        order.setOrder_id(orderId);
						order.setGoods_id(goodsId);
						order.setOrder_amount(orderAmount);
						order.setOrder_state(orderState);
						order.setOrder_price(goodPrice);
						order.setUser_name(userName);
						order.setUser_tel(userTel);
						order.setUser_address(userAddress);
				//����ҵ���߼�
						OderService ua = new OderService();
						ua.updateOrder(order);
						//��תҳ��
						RequestDispatcher rd = null;
						rd = request.getRequestDispatcher("/grzx.jsp");
						rd.forward(request, response);	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
