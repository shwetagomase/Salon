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

@WebFilter("/addservicesservlet")
public class AddServicesFilter implements Filter {

    public AddServicesFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sname=request.getParameter("sname");
		String spname=request.getParameter("spname");
  		String srate=request.getParameter("srate");
  		
		if(sname.equals("")||spname.equals("")||srate.equals(""))
		{
			 out.print("<br/> some fields are empty");
		request.getRequestDispatcher("addservices.html").include(request, response);
		}
		else {		
		chain.doFilter(request, response);
	}}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
