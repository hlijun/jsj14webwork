package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.service.ShopService;
import cn.zk.jsj14.wsgwpt.service.UserServiceImpl;

public class DelUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
				request.setCharacterEncoding("utf-8");
				//�趨��������ʽ
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				//���jspҳ�����
				String username = (String)request.getParameter("name");
				
				//����ҵ���߼�
						UserServiceImpl ga = new UserServiceImpl();
						ga.delUser(username);
						//��תҳ��
						RequestDispatcher rd = null;
						rd = request.getRequestDispatcher("/yysglzx.jsp");
						rd.forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
