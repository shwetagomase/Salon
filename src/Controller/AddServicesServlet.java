package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ServicesDao;
import Model.ServicesPojo;

@WebServlet("/addservicesservlet")
public class AddServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		System.out.println("i am Services servlet");
   		
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		
  		String sname=request.getParameter("sname");
  		String spname=request.getParameter("spname");
  		String srate=request.getParameter("srate");
  		try {						
		int a=	new ServicesDao().insert(new ServicesPojo(sname, spname, srate));
			if(a>0)
			{
				out.print("<b>Add "+sname+" service successfully</b><br/><br/>");
             request.getRequestDispatcher("admindashbord.html").include(request, response);							
			}
			else
			{
				request.getRequestDispatcher("addservices.html").include(request, response);				
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
