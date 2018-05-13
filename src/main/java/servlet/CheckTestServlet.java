package servlet;

import bean.Expression;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ZDER
 */
@WebServlet(name = "Check", urlPatterns = {"/Check"})
public class CheckTestServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<Expression> list = (List<Expression>) request.getSession().getAttribute("list");

        //判断是否正确
        for (int i = 0; i < list.size(); i++) {
            Expression expression = list.get(i);
            System.out.println("expression = " + expression.toString());

            try {

                String num = String.valueOf(i);
                System.out.println("num = " + num);
                System.out.println("i = " + i);
                String result = request.getParameter("no" + num);

                if (result == null || result == "") {
                    System.out.println("result = " + null);
                    expression.setIstrue(false);
                } else {
                    System.out.println("result = " + result);
                    expression.setResult(Integer.parseInt(result));
                    if (expression.getValue() == expression.getResult())
                        expression.setIstrue(true);
                    else
                        expression.setIstrue(false);
                }
            } catch (Exception e) {
                expression.setIstrue(false);
            }


        }

        //统计正确率
        int truenum = 0;
        int falsenum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isIstrue())
                truenum++;
            else
                falsenum++;
        }

        request.getSession().setAttribute("resultlist", list);
        request.getSession().setAttribute("truenum", truenum);
        request.getSession().setAttribute("falsenum", falsenum);
        response.sendRedirect("result.jsp");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
