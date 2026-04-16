import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S27Q2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Set the inactive time interval to 5 minutes (300 seconds)
        session.setMaxInactiveInterval(300);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Session Timeout Interval Changed</title></head>");
        out.println("<body>");
        out.println("<h1>Session Timeout Interval Changed</h1>");
        out.println("<p>The inactive time interval of the session has been changed to 5 minutes.</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
