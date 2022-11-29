package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AdminDao;
import Model.AdminPojo;

@WebServlet("/registrationadminservlet")
public class RegistrationAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		System.out.println("i am adminServlet");
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		
  		String aname=request.getParameter("aname");
  		String agender=request.getParameter("agender");
  		String aemail=request.getParameter("aemail");
  		String amobile=request.getParameter("amobile");
  		String aaddress=request.getParameter("aaddress");
		String apassword=request.getParameter("apassword");
		try {						
		int a=	new AdminDao().insert(new AdminPojo(aname, agender, aemail, amobile, aaddress, apassword));
			if(a>0)
			{
				response.sendRedirect("loginadmin");
			}
			else
			{
				request.getRequestDispatcher("registrationadmin.html").include(request, response);
				
				out.print("<b>Something Went Wrong!</b>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
		out.print("test "+aname+" "+agender+" "+aemail+" "+amobile+" "+aaddress+" "+apassword);	

  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
