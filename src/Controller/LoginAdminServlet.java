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

import Model.AdminDao;

@WebServlet("/loginadminservlet")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String aname=request.getParameter("aname");
		String apassword=request.getParameter("apassword");
		try{
			boolean a;
			try {				
				a = new AdminDao().CheckUser(aname, apassword);
				if(a){
					Cookie c=new Cookie("aname", aname);
					response.addCookie(c);
					response.sendRedirect("admindashbord.html");
				}
				else{
					request.getRequestDispatcher("loginadmin").include(request, response);
					out.print("wrong userid and password");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			}
		finally {			
		}		
	}	
}
