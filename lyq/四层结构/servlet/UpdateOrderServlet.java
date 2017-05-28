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
		//设定输入编码格式
				request.setCharacterEncoding("utf-8");
				//设定输出编码格式
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				//获得jsp页面参数
				String orderId = (String)request.getParameter("id");
				String goodsId = (String)request.getParameter("id");
				String orderAmount =(String) request.getParameter("amount");
				String orderState =(String) request.getParameter("state");
				String orderPrice = (String) request.getParameter("price");
				double goodPrice = Double.parseDouble(orderPrice);
				String userName = (String)request.getParameter("name");
				String userTel = (String)request.getParameter("tel");
				String userAddress = (String)request.getParameter("address");
				//打包处理，形成一个order对象，以便于后面传递参数使用
				      Order order  = new Order();
				        order.setOrder_id(orderId);
						order.setGoods_id(goodsId);
						order.setOrder_amount(orderAmount);
						order.setOrder_state(orderState);
						order.setOrder_price(goodPrice);
						order.setUser_name(userName);
						order.setUser_tel(userTel);
						order.setUser_address(userAddress);
				//调用业务逻辑
						OderService ua = new OderService();
						ua.updateOrder(order);
						//跳转页面
						RequestDispatcher rd = null;
						rd = request.getRequestDispatcher("/grzx.jsp");
						rd.forward(request, response);	
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
