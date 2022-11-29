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

@WebServlet("/updatecheckbookingservlet")
public class UpdateCheckBookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int apid=Integer.parseInt(request.getParameter("apid"));
		String status=request.getParameter("status");
		
		try {
			int a= new AppointmentDao().updateStatus(apid, status);
			if(a>0)
			{
				out.print("Updated!");
				request.getRequestDispatcher("checkbookingsservlet").include(request, response);

		   		//out.print("<script>alert('status updated')</script>");

				//response.sendRedirect("checkbookingsservlet");

			}
			else
				out.print("Not Updated!");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   	
   	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
