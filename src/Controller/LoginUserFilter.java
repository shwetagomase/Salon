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

@WebFilter("/loginuserservlet")
public class LoginUserFilter implements Filter {

    public LoginUserFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("uname");
		String upassword=request.getParameter("upassword");	
		
		if(uname.equals("")||upassword.equals(""))
		{
			 out.print("<br/> some fields are empty");
		request.getRequestDispatcher("loginuser").include(request, response);
		}
		else {		
				chain.doFilter(request, response);			
		}}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
