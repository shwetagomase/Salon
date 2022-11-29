package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookappointment")
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		response.setContentType("text/html");
   		PrintWriter out=response.getWriter();
   		
   		String sname=request.getParameter("sname");
		String spname=request.getParameter("spname");
		String srate=request.getParameter("srate");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		String status=request.getParameter("status");


	out.print("<form action='bookappointmentservlet'>");
	out.print("<h3>Appointment</h3>");
out.print("<tr><th>service name :</th><td><input type='text'name='sname' value='"+sname+"' ></td></tr> <br/><br/>");		   
out.print("<tr><th>Service Provider Name :</th><td><input type='text' name='spname' value='"+spname+"'></td></tr><br/><br/>");
out.print("<tr><th>Service Rate :</th><td><input type='text'name='srate' value='"+srate+"' ></td></tr> <br/><br/>");		   
out.print("<tr><th>Date :<th><td><input type='date' id='date' name='date' value='"+date+"'></td><tr> <br/><br/>"); 
out.print("<tr><th>Time :<th><td><input type='time' id='appt' name='btime' value='"+time+"'></td><tr> <br/><br/>"); 
out.print("<tr><td><input type='hidden' name='status' value='pending'></td><tr> <br/><br/>"); 

out.print("<tr><td><input type='submit' value='book' > </td></tr><br/> <br/> ");
  out.print("</form>");
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
