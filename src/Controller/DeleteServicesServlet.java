package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ServicesDao;

@WebServlet("/deleteservicesservlet")
public class DeleteServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		
  		int sid=Integer.parseInt(request.getParameter("sid"));

  		try {
			boolean a=new ServicesDao().deleteServices(sid);
			if(a)
			{
				out.print("<b>delete service successfully</b><br/><br/>");
	             request.getRequestDispatcher("showservicesservlet").include(request, response);											
			}
			else
			{
				out.print("user not delete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	   	
  	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
