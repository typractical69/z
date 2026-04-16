import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S18Q2 extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int seatNo = Integer.parseInt(req.getParameter("seat_no"));
        String name = req.getParameter("name");
        String stuClass = req.getParameter("class");
        int totalMarks = Integer.parseInt(req.getParameter("total_marks"));

        double perc = (totalMarks / 500.0) * 100;
        String grade;
        if (perc >= 90)       grade = "A+";
        else if (perc >= 80)  grade = "A";
        else if (perc >= 70)  grade = "B";
        else if (perc >= 60)  grade = "C";
        else if (perc >= 50)  grade = "D";
        else                  grade = "Fail!";

        out.println("<html><head><title>Student Details</title></head><body>");
        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No.: " + seatNo + "</p>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Class: " + stuClass + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + perc + "</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");
        out.close();
    }
}
