import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S15Q2 extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html");

        int visitCount = 0;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                    break;
                }
            }
        }

        PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        if (visitCount == 0)
            out.println("<h1>Welcome! This is your first visit to the page.</h1>");
        else
            out.println("<h1>Welcome back! You've visited this page " + visitCount + " times.</h1>");

        visitCount++;
        Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));
        res.addCookie(visitCookie);

        out.println("<form method=\"post\">");
        out.println("<input type=\"submit\" value=\"Refresh\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        doGet(req, res);
    }
}
