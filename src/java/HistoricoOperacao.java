/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Icaro
 */
@WebServlet(urlPatterns = {"/HistoricoOperacao"})
public class HistoricoOperacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet HistoricoOperacao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HistoricoOperacao at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY"); 
        float saldo = 0;
        response.setCharacterEncoding("UTF-8");
        response.getWriter().println("<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <title>Cadastrar Operação</title>\n" +
"    </head>\n" +
"    <body>\n" +
"            <ul>\n" +
"                <li><a href=\"cadastrar-conta.jsp\">Cadastrar Conta</a></li>\n" +
"                <li><a href=\"cadastrar-operacao.jsp\">Cadastrar Operação</a></li>\n" +
"                <li><a href=\"historico-operacao.jsp\">Histórico de Operações</a></li>\n" +
"            </ul>");
        
        try {
        response.getWriter().println("<table border='1px' width='300px'>");
        response.getWriter().println("<tr><td colspan='2' align='center'>Extrato da Conta Nº "+numero+"</td></tr>");
        response.getWriter().println("<tr><td>CPF Responsavel</td><td>Valor</td></tr>");
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/conta", "root", "");
            PreparedStatement stm = conexao.prepareStatement("SELECT * FROM `operacoes` WHERE `numConta` = ?");
            stm.setInt(1, numero);
            ResultSet re = stm.executeQuery();
            while(re.next()){
                response.getWriter().println("<tr><td>"+re.getString("cpfResponsavel")+"</td>");
                response.getWriter().println("<td>"+re.getString("valor")+"</td></tr>");
                saldo = saldo + Float.parseFloat(re.getString("valor"));
            }
            conexao.close();
            response.getWriter().println("<tr><td>Saldo</td><td>"+saldo+"</td></tr>");
            response.getWriter().println("</table>");
        } catch (SQLException ex) {
            response.getWriter().println("Erro: " + ex);
        } catch (ClassNotFoundException e) {
            response.getWriter().println("Erro: " + e);
        }
        response.getWriter().println("</body></html>");
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
