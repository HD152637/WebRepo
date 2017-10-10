package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVO;

/**
 * Servlet implementation class BlogLoginServlet
 */
@WebServlet("/bloglogin")
public class BlogLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("myblog/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("loginId");
		String pwd = request.getParameter("loginPwd");
		System.out.println(id + " " + pwd);
		
		String test = "test@naver.com";
		boolean result;
		
		if(id.equals(test)){
			result = true;
//			HttpSession session = request.getSession();
//			
//			UserVO user = new UserVO();
//			user.setId(id);
//			user.setName("홍길동");
//			user.setNickname("의적 ");
//			session.setAttribute("user", user);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("myblog/index.jsp");
//			rd.forward(request, response);
		} else{
			result = false;
//			request.setAttribute("msg", "error");
//			RequestDispatcher rd = request.getRequestDispatcher("myblog/login.jsp");
//			rd.forward(request, response);
		}
		
		out.print(result);
		out.close();
	}

}
