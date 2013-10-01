package com.judepereira.college.aj.practicals.currencyconverter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jude Pereira
 */
public class ConvertServlet extends HttpServlet {

    @EJB
    private ConvertSessionBean sb;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            double amount = Double.parseDouble(request.getParameter("amount"));
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConvertServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Result: " + sb.convert(from, to, amount) + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
