package cn.zk.jsj14.wsgwpt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zk.jsj14.wsgwpt.domain.Carrieroperator;
import cn.zk.jsj14.wsgwpt.service.CarrieroperatorService;

public class UpdateyysServlet extends HttpServlet {

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
				String userPassword =(String) request.getParameter("password");
				Carrieroperator xiaoer  = new Carrieroperator();
				xiaoer.setCarrieroperator_name(userName);
				xiaoer.setCarrieroperator_pwd(userPassword);
				//����ҵ���߼�
				CarrieroperatorService ls = new CarrieroperatorService();
				ls.updatePwd(xiaoer);
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
