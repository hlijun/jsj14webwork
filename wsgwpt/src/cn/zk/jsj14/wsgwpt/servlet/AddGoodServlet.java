package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;
import cn.zk.jsj14.wsgwpt.service.GoodService;

public class AddGoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
				request.setCharacterEncoding("utf-8");
				//�趨��������ʽ
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				//���jspҳ�����
				String goodId = (String)request.getParameter("goods_id");
				String goodName = (String)request.getParameter("goods_name");
				String goodamount = (String)request.getParameter("goods_amount");
				double goodAmount = Double.parseDouble(goodamount);
				String goodType = (String)request.getParameter("goods_type");
				String goodprice = (String)request.getParameter("good_price");
				double goodPrice = Double.parseDouble(goodprice);
				//��������γ�һ�������Ա��ں��洫�ݲ���ʹ��
				Goods_imformation good  = new Goods_imformation();
				        good.setGoods_id(goodId);
						good.setGoods_name(goodName);
						good.setGoods_amount(goodAmount);
						good.setGoods_type(goodType);
						good.setGood_price(goodPrice);
						
				//����ҵ���߼�
						GoodService ga = new GoodService();
						ga.addGood(good);
						//��תҳ��
						RequestDispatcher rd = null;
						rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);	
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
