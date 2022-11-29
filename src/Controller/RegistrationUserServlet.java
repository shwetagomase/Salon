package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserDao;
import Model.UserPojo;

@WebServlet("/registrationuserservlet")
public class RegistrationUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		
  		String uname=request.getParameter("uname");
  		String ugender=request.getParameter("ugender");
  		String uemail=request.getParameter("uemail");
  		String umobile=request.getParameter("umobile");
  		String uaddress=request.getParameter("uaddress");
		String upassword=request.getParameter("upassword");
		try {						
		int a=	new UserDao().insert(new UserPojo(uname, ugender, uemail, umobile, uaddress, upassword));
			if(a>0)
			{
				response.sendRedirect("loginuser");
			}
			else
			{
				request.getRequestDispatcher("registrationuser.html").include(request, response);				
				out.print("<b>Something Went Wrong!</b>");
			}			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
