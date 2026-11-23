import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicInteger;


public class ActiveSessionListener implements HttpSessionListener {

    private AtomicInteger activeSessions = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        int count = activeSessions.incrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", count);

        System.out.println("Active sessions: " + count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {
        int count = activeSessions.decrementAndGet();

        ServletContext context = event.getSession().getServletContext();
        context.setAttribute("activeSessions", count);

        System.out.println("Active sessions: " + count);
    }
}