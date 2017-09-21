package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// 입력 데이터 처리
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
		// 출력데이터 Content Tpye 설정
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Text</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello, Servlet</h1>");
		out.println("<h1>안녕, 서블릿</h1>");
		out.println("<h2>id : " + id + ", name : " + name + "</h2>");
		out.println("</body>");
		out.println("</html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost() 호출됨");
		doGet(request, response);
	}
	
	@Override
	public void init() throws ServletException {
		// 최초 메모리 로딩시에 1회 호출
		System.out.println("init() 호출");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service() 호출");
		super.service(arg0, arg1);
	}
	
	@Override
	public void destroy() {
		// 메모리에서 해제 시 호출됨
		// 서버를 중지시키거나, 소스가 변경된 경우
		System.out.println("destroy() 호출");
	}
	 

}
