import java.io.*;
import jakarta.servlet.http.*;

public class ReadCookie extends HttpServlet{

protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
Cookie[] cookies = request.getCookies();
if (cookies != null) {
for (Cookie r_c : cookies) {
out.print(r_c.getName() + ": " + r_c.getValue()+"<br>");
}
}
}
}