package com.wolf.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:Servlet能动态显示网页内容
 * <br/> Created on 2016/12/6 8:43
 *
 * @author 李超()
 * @since 1.0.0
 */
public class DynamicContentServlet extends HttpServlet {

	private static final long serialVersionUID = -1915463532411657451L;

	@Override
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response) throws ServletException, IOException {
		//获取初始化参数
		String name = getServletConfig().getInitParameter("name");
		System.out.println(name);

		Map<String, String> data = getData();

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// Write some content
			out.println("<html>");
			out.println("<head>");
			out.println("<title>CalendarServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Hello " + data.get("username") + ", " + data.get("message") + "</h2>");
			out.println("<h2>The time right now is : " + new Date() + "</h2>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

	//This method will access some external system as database to get user name, and his personalized message
	private Map<String, String> getData() {
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", "Guest");
		data.put("message", "Welcome to my world !!");
		return data;
	}

}