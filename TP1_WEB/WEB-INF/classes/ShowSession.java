import java.io.*;
import jakarta.servlet.http.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import jakarta.servlet.*;

public class ShowSession extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	/* Test Application Attributes
ServletContext context = getServletContext();

context.setAttribute("appName", "My Application");
context.setAttribute("appName", "My Web Application");
context.removeAttribute("appName");

// Test Request Attributes
request.setAttribute("message", "Hello");
request.setAttribute("message", "Welcome");
request.removeAttribute("message");*/

        int nb = 1;
        HttpSession s = request.getSession(true);

        Integer active = (Integer) getServletContext().getAttribute("activeSessions");
        out.println("<h2>Active sessions: " + active + "</h2>");

        if (s.isNew()) {
            s.setAttribute("track", nb);
            out.println("<h1>Welcome on my site!</h1>");
        } else {
            if (s.getAttribute("track") == null) {
                s.setAttribute("track", 0);
            }
            s.setAttribute("track", (Integer) s.getAttribute("track") + 1);
            out.println("<h1>Welcome back</h1>");
        }

        out.println("Visits: " + s.getAttribute("track") + "<br>");

        out.println("<form method='post' action='ShowSession'>");
        out.println("<label for='fullname'>Full name:</label><br>");
        out.println("<input type='text' id='fullname' name='fullname' required><br>");
        out.println("<label for='birth'>Birth date:</label><br>");
        out.println("<input type='date' id='birth' name='birth' required><br>");
        out.println("<input type='submit' value='Submit'>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession s = request.getSession();

        String fullname = request.getParameter("fullname");
        String birthD = request.getParameter("birth");

        s.setAttribute("fullname", fullname);
        s.setAttribute("birth", birthD);

        LocalDate birth = LocalDate.parse(birthD);
        LocalDate date = LocalDate.now();

        birth = birth.withYear(date.getYear());

        if (birth.isBefore(date)) {
            birth = birth.plusYears(1);
        }

        long per = ChronoUnit.DAYS.between(date, birth);

        out.println("<h1>Welcome!</h1>");
        out.println("<p>Hi, " + fullname +
                    "! There are " + per +
                    " days until your birthday.</p>");
        out.println("<a href='ShowSession'>Back to form</a>");
    }
}