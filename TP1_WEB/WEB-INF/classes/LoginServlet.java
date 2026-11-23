import java.io.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{

response.setContentType("text/html");
PrintWriter out;
out = response.getWriter();
String name = request.getParameter("username");
HttpSession session = request.getSession(true);

session.setAttribute("user", name);
out.println("<html>");
out.println("<head><title>LoginServlet</title></head>");
out.println("<body>");
out.println(name+": Successful login!<br>");
out.println("<a href=\"items.html\">Items</a>");
out.println("</body>");
out.println("</html>");

out.close();
}

}