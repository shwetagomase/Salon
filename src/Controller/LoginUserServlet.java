package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserDao;

@WebServlet("/loginuserservlet")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upassword=request.getParameter("upassword");		
		try{
			boolean a;
			try {				
				a = new UserDao().CheckUser(uname, upassword);
				if(a){
					Cookie c=new Cookie(uname, uname);
					response.addCookie(c);
					response.sendRedirect("appointmentuserservices");
				}
				else{
					request.getRequestDispatcher("loginuser").include(request, response);
					out.print("wrong userid and password");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			}
		finally {			
		}		
	}}	