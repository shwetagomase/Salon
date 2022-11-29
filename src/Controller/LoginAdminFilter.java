package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/loginadminservlet")
public class LoginAdminFilter implements Filter {

    public LoginAdminFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String aname=request.getParameter("aname");
		String apassword=request.getParameter("apassword");	
		
		if(aname.equals("")||apassword.equals(""))
		{
			 out.print("<br/> some fields are empty");
		request.getRequestDispatcher("loginadmin").include(request, response);
		}
		else {		
				chain.doFilter(request, response);			
		}}		
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
