package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ServicesDao;

@WebServlet("/updateservicesservlet")
public class UpdateServicesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	int sid=Integer.parseInt(request.getParameter("sid"));
	    String sname=request.getParameter("sname");
		String spname=request.getParameter("spname");
		String srate=request.getParameter("srate");
		try {
			int a1=	new ServicesDao().updateServices(sid, sname, spname, srate);
			if(a1>0)
			{
				out.print("<b>Update service successfully</b><br/><br/>");
	         request.getRequestDispatcher("showservicesservlet").include(request, response);							
			}
			else
			{
				out.print("<b>Something Went Wrong!</b>");
				request.getRequestDispatcher("admindashbord.html").include(request, response);				
			}			

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
			
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
