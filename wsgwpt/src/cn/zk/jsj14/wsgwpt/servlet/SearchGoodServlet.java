package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.zk.jsj14.wsgwpt.domain.Goods_imformation;
import cn.zk.jsj14.wsgwpt.service.GoodService;

public class SearchGoodServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//���jspҳ�����
		String name = request.getParameter("index_none_header_sysc");
		// ����ҵ���߼�
		GoodService gs = new GoodService();
		List<Goods_imformation> list = gs.searchGood(name);
		// �ַ�ת��
		request.setAttribute("goods", list);// ��list����request������
		request.getRequestDispatcher("/searchgood.jsp").forward(
				request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
