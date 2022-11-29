package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.UserDao;
import Model.UserPojo;

@WebServlet("/profileuserservlet")
public class ProfileUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String spageid = request.getParameter("page");
		System.out.println("data "+spageid);
		int pageid = Integer.parseInt(spageid);
		Cookie c[] = request.getCookies();

		if (c != null) {

			String uname = c[0].getValue();

			out.print("welcome to profile User : " + uname);

			out.print(" &nbsp;&nbsp;&nbsp;<a href='logoutuserserv'>logout</a>");

			int total = 5;
			if (pageid == 1) {
			} else {
				pageid = pageid - 1;
				pageid = pageid * total + 1;
			}
			List<UserPojo> list;
			list = new UserDao().getAllUser(pageid, total);
			out.print("<h1>Page No: " + spageid + "</h1>");
			out.print("<table>");
			out.print("<tr><th>Id</th><th>Name</th><th>FName</th></tr>");
			for (UserPojo e : list) {
				out.print("<tr><td>" + e.getUid() + "</td><td>" + e.getUname() + "</td><td>" + e.getUpassword()
						+ "</td></tr>");
			}
			out.print("</table>");
			 out.print("<a href='profileserv?page=1'>1</a>");
			 out.print("<a href='profileserv?page=2'>2</a>");
			 out.print("<a href='profileserv?page=3'>3</a>");
		} else {

			request.getRequestDispatcher("loginuser").include(request, response);
			out.print("Please login first");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
