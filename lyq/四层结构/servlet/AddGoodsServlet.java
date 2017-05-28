package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;
import cn.zk.jsj14.wsgwpt.service.GoodsService;

public class AddGoodsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获得jsp页面参数
		String goodsId = (String)request.getParameter("id");
		String goodsName = (String)request.getParameter("name");
		String goodsAmount =(String) request.getParameter("amount");
		String goodsType =(String) request.getParameter("type");
		String goodPrice = (String) request.getParameter("price");
		double goodsPrice = Double.parseDouble(goodPrice);
		//打包处理，形成一个user对象，以便于后面传递参数使用
		Goods_imformation goods  = new Goods_imformation();
				goods.setGoods_id(goodsId);
				goods.setGoods_name(goodsName);
				goods.setGoods_amount(goodsAmount);
				goods.setGoods_type(goodsType);
				goods.setGood_price(goodsPrice);
				
		//调用业务逻辑
				GoodsService ua = new GoodsService();
				ua.addGoods(goods);
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
