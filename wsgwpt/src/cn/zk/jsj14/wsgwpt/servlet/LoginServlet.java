package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.zk.jsj14.wsgwpt.domain.User;
import cn.zk.jsj14.wsgwpt.service.LoginService;



public class LoginServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	LoginService ls = new LoginService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�趨��������ʽ
		request.setCharacterEncoding("utf-8");
		//�趨��������ʽ
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
        //		���jspҳ�����
		String userName = (String)request.getParameter("name");
		String userPassword =(String) request.getParameter("password");
		
		//��������γ�һ��user�����Ա��ں��洫�ݲ���ʹ��
		User user  = new User();
		user.setUser_name(userName);
		user.setUser_pwd(userPassword);
		
		boolean checkResult = false ;
		String msg = null;
		
		RequestDispatcher rd = null;
		try{
			checkResult = ls.checkUserNameAndPassword(user);
			
			if(checkResult == true){
				 msg = userName;
				// request.setAttribute("MSG", msg);
				//ʹ��request�����getSession()��ȡsession�����session�������򴴽�һ��
				HttpSession session = request.getSession();
				//�����ݴ洢��session��
		        session.setAttribute("data", msg);
				rd = request.getRequestDispatcher("/index.jsp");
			}else{
					
				rd = request.getRequestDispatcher("/login.jsp");
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			
			//request.setAttribute("MSG", );
			rd.forward(request, response);
			
		}
		
		}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
