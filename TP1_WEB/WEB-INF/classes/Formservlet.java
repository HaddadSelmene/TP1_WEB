import java.io.*;
import jakarta.servlet.http.*;

public class Formservlet extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{

response.setContentType("text/html");
PrintWriter out;
out = response.getWriter();
String fname = request.getParameter("fname");
String lname = request.getParameter("lname");
String birth = request.getParameter("birth");
String sexe = request.getParameter("sexe");
Cookie firstName=new Cookie("firstName",fname);
Cookie lastName=new Cookie("lastName",lname);
Cookie birthDay=new Cookie("birthDay",birth);
Cookie sex=new Cookie("Sex",sexe);


response.addCookie(firstName);
response.addCookie(lastName);
response.addCookie(birthDay);
response.addCookie(sex);


out.println("<html>");
out.println("<head><title>FormServlet</title></head>");
out.println("<body>");
out.println("<table border='1'>");
out.println("<tr>");
out.println("<td>First Name:</td>");
out.println("<td>"+fname+"</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>Last Name:</td>");
out.println("<td>"+lname+"</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>Birth date:</td>");
out.println("<td>"+birth+"</td>");
out.println("</tr>");
out.println("<tr>");
out.println("<td>Sexe:</td>");
out.println("<td>"+sexe+"</td>");
out.println("</tr>");
out.println("</table>");
out.println("</body>");
out.println("</html>");
out.close();


}

}