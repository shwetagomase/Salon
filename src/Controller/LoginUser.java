package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginuser")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
  		Cookie ck[]=request.getCookies();
	if(ck==null)
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("<h3>Welcome to Saloon</h3>");
		out.print("<br/>login page<br/><br/>");
		out.print("<form action='loginuserservlet' method='post'>");
		out.print("User Name:<input type='text' name='uname' placeholder='user name...'><br/><br/>");
		out.print("Password :<input type='text' name='upassword' placeholder='password...'><br/><br/>");
		out.print("<input type='submit' value='login'><br/><br/>");
		out.print("</form>");

		out.print("Not Already Register go to ");
		out.print("<a href='registrationuser.html'>Registration</a>");
		out.print("<br/>");		
	}
	else
	{
		response.sendRedirect("appointmentuserservices");
	}
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
