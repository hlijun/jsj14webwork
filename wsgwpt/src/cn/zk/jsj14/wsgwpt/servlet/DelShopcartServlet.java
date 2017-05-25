package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.zk.jsj14.wsgwpt.service.ShopcartService;

public class DelShopcartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
				request.setCharacterEncoding("utf-8");
				//�趨��������ʽ
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				//���jspҳ�����
				String id = (String)request.getParameter("thing_id");
				
				//����ҵ���߼�
						ShopcartService ga = new ShopcartService();
						ga.delShopcart(id);
						//��תҳ��
						RequestDispatcher rd = null;
						rd = request.getRequestDispatcher("/gwc.jsp");
						rd.forward(request, response);	

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
