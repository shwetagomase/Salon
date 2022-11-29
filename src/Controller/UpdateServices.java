package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateservices")
public class UpdateServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		
   		String sname=request.getParameter("sname");
		String spname=request.getParameter("spname");
		String srate=request.getParameter("srate");
		int sid=Integer.parseInt(request.getParameter("sid"));
	out.print("<form action='updateservicesservlet'>");
		 out.print("<h3>update service id:"+sid+"</h3>");
		 out.print("<input type='hidden' name='sid' value='1'>");
out.print("<tr><th>service name :</th><td><input type='text'name='sname' value='"+sname+"' ></td></tr> <br/><br/>");		   
out.print("<tr><th>Service Provider Name :</th><td><input type='text' name='spname' value='"+spname+"'></td></tr><br/><br/>");
out.print("<tr><th>Service Rate :</th><td><input type='text'name='srate' value='"+srate+"' ></td></tr> <br/><br/>");		   
  out.print("<tr><td><input type='submit' value='save' > </td></tr><br/> <br/> ");
  out.print("</form>");
  request.getRequestDispatcher("showservicesservlet").include(request, response);							

   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
