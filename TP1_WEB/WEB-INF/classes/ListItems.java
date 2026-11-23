import java.io.*;
import jakarta.servlet.http.*;
import java.util.*;

public class ListItems extends HttpServlet{

public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{

//response.setContentType("text/html");
//PrintWriter out;
//out = response.getWriter();

HttpSession s = request.getSession(true);


String item = request.getParameter("newItem");
ArrayList<String> list =
    (ArrayList<String>) s.getAttribute("llist");
if (list == null) {
    list = new ArrayList<String>();
    s.setAttribute("llist", list);
}

list.add(item);
response.sendRedirect("ListItems");


}
 public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession s = request.getSession(false);

        out.println("<html>");
        out.println("<head><title>ItemsServlet</title></head>");
        out.println("<body>");
        out.println("<h1>My Items</h1>");
        out.println("<ul>");

        if (s != null && s.getAttribute("llist") != null) {
            ArrayList<String> list =
                (ArrayList<String>) s.getAttribute("llist");

            for (String item : list) {
                out.println("<li>" + item + "</li>");
            }
        }

        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }
}