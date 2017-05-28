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

public class AddUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设定输入编码格式
		request.setCharacterEncoding("utf-8");
		//设定输出编码格式
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//获得jsp页面参数
		String userName = (String)request.getParameter("name");
		String userPassword =(String) request.getParameter("password");
		//打包处理，形成一个user对象，以便于后面传递参数使用
				User user  = new User();
				user.setUser_name(userName);
				user.setUser_pwd(userPassword);
		//调用业务逻辑
				UserServiceImpl ua = new UserServiceImpl();
				ua.addUser(user);
				//跳转页面
				RequestDispatcher rd = null;
				rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
