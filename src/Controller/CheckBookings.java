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

@WebServlet("/checkbookings")
public class CheckBookings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		out.print("<h3> Appointment List</h3>");
		List<AppointmentPojo> list=AppointmentDao.ShowData();

  		  out.print("<table border='1'>");
  		 out.print("<tr><th>Appointment id</th> <th>Service name</th><th>Service provider name</th><th>Service rate</th><th>Date</th><th>Time</th><th>Action </th></tr>");
  		 for(AppointmentPojo s:list){
  		out.print("<tr><td>"+s.getApid()+"</td><td>"+s.getSname()+"</td><td>"+s.getSpname()+"</td><td>"+s.getSrate()+"</td><td>"+s.getDate()+"</td><td>"+s.getTime()+"</td><td><a href='checkbookingsservlet?sname="+s.getSname()+"&spname="+s.getSpname()+"&srate="+s.getSrate()+"&date"+s.getDate()+"&time"+s.getTime()+"'><label><option value='pending'>pending</option><option value='accept'>accept</option><option value='reject'>reject</option></label></a></td></tr>");	//Accept/Reject/Pending  		 
  		 }
  		 out.print(" </table>");
  		 out.close();  			
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
