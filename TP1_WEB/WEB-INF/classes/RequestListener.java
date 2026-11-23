import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;


public class RequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        System.out.println("Request Initialized!");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        System.out.println("Request Destroyed!");
    }
}