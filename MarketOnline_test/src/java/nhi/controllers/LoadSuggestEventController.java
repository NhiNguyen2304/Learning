/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nhi.daos.SuggestEventDAO;
import nhi.dtos.SuggestEventDTO;

/**
 *
 * @author admin
 */
public class LoadSuggestEventController extends HttpServlet {

    private final String error = "error.jsp";
    private final String loadSuggPage = "loadSuggest.jsp";
    private final String loadOwnSugg = "viewOwnSugg.jsp";

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
        String url = error;
        try {
            SuggestEventDAO dao = new SuggestEventDAO();
            String action = request.getParameter("action");
            if (action.equals("LoadYour")) {
                String name = request.getParameter("txtUsername");
                List<SuggestEventDTO> resultOwn = dao.loadSuggestEventWithKey(name);
                if (resultOwn != null) {
                    request.setAttribute("LOADYOURSUGG", resultOwn);
                    url = loadOwnSugg;
                } else {
                    request.setAttribute("ERROR", "Can't find your search");
                }
            }
            if (action.equals("Load")) {
                List<SuggestEventDTO> result = dao.loadSuggestEvent();

                if (result != null) {
                    request.setAttribute("LOADSUGG", result);
                    url = loadSuggPage;
                } else {
                    request.setAttribute("ERROR", "Can't find your search");
                }
            }
            else{
                 request.setAttribute("ERROR", "Can't find your search");
            }

        } catch (Exception e) {
           
            log("ERROR at LoadSuggestEventController " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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