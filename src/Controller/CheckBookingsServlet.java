package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AppointmentDao;
import Model.AppointmentPojo;
import Model.ServicesDao;
import Model.ServicesPojo;

@WebServlet("/checkbookingsservlet")
public class CheckBookingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		
  		  out.print("<h3>Appointment</h3>");
  		  List<AppointmentPojo> list=AppointmentDao.ShowData();
  		  out.print("<table border='1'>");
  		 out.print("<tr> <th>Appointment id</th><th>Service name</th><th>Service provider name</th><th>Service rate</th><th>Date</th><th>Time</th><th>Status </th></tr>");
  		 for(AppointmentPojo s:list)
  		 {
  	  		String status=s.getStatus();

  		out.print("<tr><td>"+s.getApid()+"</td><td>"+s.getSname()+"</td><td>"+s.getSpname()+"</td><td>"+s.getSrate()+"</td><td>"+s.getDate()+"</td><td>"+s.getTime()+"</td>");
  		out.print("<form action='updatecheckbookingservlet'>");	
  		out.print("<input type='hidden' name='apid' value='"+s.getApid()+"'>");
  		out.print("<td><select name='status' value='"+s.getStatus()+"'><option value='pending' if(status.equals('pending')selected>Pending</option><option value='accept'if(status.equals('accept')selected>Accept</option><option value='reject'if(status.equals('reject')selected>Reject</option></select></td>");
  		out.print("<td><input type='submit'></td></tr>");
  		out.print("</form>");  		 
  		 }
  		 out.print(" </table>");
  		 out.close();
  		 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
