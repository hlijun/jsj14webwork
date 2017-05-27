package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.User;
import cn.zk.jsj14.wsgwpt.service.UserServiceImpl;

public class YUpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//���jspҳ�����
		String userName = (String)request.getParameter("name");
		String userTruename =(String) request.getParameter("username");
		String userTel = (String) request.getParameter("tel");
		String userAddress = (String) request.getParameter("address");
		//��������γ�һ��user�����Ա��ں��洫�ݲ���ʹ��
				User user1  = new User();
				user1.setUser_name(userName);
				user1.setUser_truename(userTruename);
				user1.setUser_tel(userTel);
				user1.setUser_address(userAddress);
		//����ҵ���߼�
				UserServiceImpl ua = new UserServiceImpl();
				ua.yupdateUser(user1);
				//��תҳ��
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/yysglzx.jsp");
				rd.forward(request, response);	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
