import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;

public class ApplicationListener implements ServletContextListener{

@Override
public void contextInitialized(ServletContextEvent event) {
System.out.println("Application Started!");
ServletContext context = event.getServletContext();
context.setAttribute("appName","ING1 Web Application");
}

@Override
public void contextDestroyed(ServletContextEvent event) {
System.out.println("Application Stopped!");
}

}