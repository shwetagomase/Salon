package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ServicesDao;
import Model.ServicesPojo;

@WebServlet("/appointmentuserservices")
public class AppointmentUserServices extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setContentType("text/html");
  		PrintWriter out=response.getWriter();
  		out.print("<h3>Welcome to Saloon</h3>");
  		out.print("<h3>Book Appointment here</h3>");

  		  out.print("<h3>Our Salon Services</h3>");
  		  List<ServicesPojo> list=ServicesDao.ShowData();
  		  out.print("<table border='1'>");
  		 out.print("<tr> <th>Service name</th><th>Service provider name</th><th>Service rate</th><th>Action </th></tr>");
  		 for(ServicesPojo s:list){
  		out.print("<tr><td>"+s.getSname()+"</td><td>"+s.getSpname()+"</td><td>"+s.getSrate()+"</td><td><a href='bookappointment?sname="+s.getSname()+"&spname="+s.getSpname()+"&srate="+s.getSrate()+"'>Book</a></td></tr>");	 
  		 
  		 }
  		 out.print(" </table>");
  		 out.close();
  			
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
