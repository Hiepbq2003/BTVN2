
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author bachk
 */
@WebServlet(name="hihi", urlPatterns={"/btvn2"})
public class hihi extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hihi</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hihi at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String choice = request.getParameter("lc");
    String address = request.getParameter("dc");
    String name = request.getParameter("name");
    String[] foods = request.getParameterValues("food");
    String ms = "";
    String job = request.getParameter("nghich");
    
    try (PrintWriter out = response.getWriter()) {
        if (choice == null || choice.equalsIgnoreCase("N")) {
            ms = "Chúng tôi không thể chấp nhận yêu cầu bạn";
        } else {
            if (name == null || name.isBlank()) {
                ms = "Không được để trống tên";
            } else if (address == null || address.isBlank()) {
                ms = "Không được để trống địa chỉ";
            } else {
                StringBuilder foodList = new StringBuilder();
                if (foods != null) {
                    for (String food : foods) {
                        foodList.append(food).append(", ");
                    }
                    if (foodList.length() > 0) {
                        foodList.setLength(foodList.length() - 2);
                    }
                }
                ms = String.format("%s (%s) - %s - %s", name, address, foodList.toString(), job);
            }
        }
        out.println("<h1 style=\"color:blue;\">" + ms + "</h1>");
    } catch (Exception e) {
        e.printStackTrace();
    }
    
    }  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
