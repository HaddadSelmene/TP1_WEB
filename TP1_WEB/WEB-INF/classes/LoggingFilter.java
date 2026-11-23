import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;


 
public class LoggingFilter implements jakarta.servlet.Filter{

@Override
public void init(FilterConfig fc) throws ServletException{
//System.out.println("Initialisation du filtre.");
System.out.println(fc.getInitParameter("logPrefix"));
}

@Override
public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws IOException,ServletException{

HttpServletRequest httpRequest = (HttpServletRequest) request;
StringBuilder requestUrl = new StringBuilder(httpRequest.getRequestURL().toString());
String queryString = httpRequest.getQueryString();

if (queryString != null) {
            requestUrl.append("?").append(queryString);
        }

System.out.println("Intercepted Request URL: " + requestUrl.toString());
System.out.println("Request Processed.");

System.out.println("Welcome_Log!");
chain.doFilter(request, response);
System.out.println("Goodbye_Log!");

}

@Override
public void destroy(){
System.out.println("Filter Destroyed.");
}

}