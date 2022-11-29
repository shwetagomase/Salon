package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AppointmentDao;
import Model.AppointmentPojo;

@WebServlet("/bookappointmentservlet")
public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
  		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		out.print("<script>alert('booking confirm')</script>");

       String sname=request.getParameter("sname");
  		String spname=request.getParameter("spname");
  		String srate=request.getParameter("srate");
  		String date=request.getParameter("date");
  		String time=request.getParameter("btime");
  		String status=request.getParameter("status");

  		   	 try {	
  			int a=new AppointmentDao().insert(new AppointmentPojo(sname, spname, srate, date, time, status));
			if(a>0)
			{
  				response.sendRedirect("checkbookingsuser");  		
			}
			else
			{
				out.print("<b>Something Went Wrong!</b>");
				out.print("<script>alert('wrong username and password')</script>");
			}			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}		
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
