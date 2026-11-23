import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;


public class SecurityFilter implements jakarta.servlet.Filter{

@Override
public void init(FilterConfig fc) throws ServletException{
//System.out.println("SecurityFilter.");
System.out.println(fc.getInitParameter("sec"));
}

@Override
public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException,ServletException{

HttpServletRequest httpRequest = (HttpServletRequest) request;
HttpServletResponse httpResponse = (HttpServletResponse) response;

HttpSession session = httpRequest.getSession(false);
if (session != null && session.getAttribute("user") != null){
System.out.println("Welcome_Security!");
chain.doFilter(request, response);
System.out.println("Goodbye_Security!");
}
else{
System.out.println("Redirection.");
httpResponse.sendRedirect("login.html");
}

}

@Override
public void destroy(){
System.out.println("Filter Security Destroyed.");
}

}