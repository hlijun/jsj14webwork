package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.User;
import cn.zk.jsj14.wsgwpt.service.UserServiceImpl;

public class CkUserServlet extends HttpServlet {

	
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
		String method = (String)request.getParameter("method");
		//����ҵ���߼�
		UserServiceImpl ua = new UserServiceImpl();
		 User user = new User();
			user = ua.selectUser(username);
		 request.setAttribute("user", user);
		//��תҳ��
		 RequestDispatcher rd = null;
		 if(method.equals("cx"))
		 {
		     rd = request.getRequestDispatcher("/yyscxusergo.jsp");
		 }else{
			 rd = request.getRequestDispatcher("/yysupdateusergo.jsp");
		 }
		rd.forward(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
