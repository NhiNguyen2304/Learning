/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhi.daos.SuggestEventDAO;
import nhi.dtos.PostInformationDTOErrObj;
import nhi.dtos.SuggestEventDTO;
import nhi.dtos.SuggestEventErrObj;

/**
 *
 * @author admin
 */
public class SuggestEventController extends HttpServlet {

    private final String error = "error.jsp";
    private final String success = "staffSuggest.jsp";
    private final String fail = "staffSuggest.jsp";

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
            String staffName = request.getParameter("txtStaffName");
            String title = request.getParameter("txtTitleSuggest");

            boolean validDate = true;
            SuggestEventErrObj errObj = new SuggestEventErrObj();
            Date temp = Date.valueOf(LocalDate.now());

            String start = request.getParameter("txtTimeStartSuggest");
            Date suggestStart = Date.valueOf(start);
            if (temp.after(suggestStart)) {
                validDate = false;
                errObj.setDateStartSugErr("Date start was passed");
            }

            String end = request.getParameter("txtTimeEndSuggest");
            Date suggestEnd = Date.valueOf(end);
            if (temp.after(suggestEnd)) {
                validDate = false;
                errObj.setDateEndSuggEr("Date end was passed");
            }
            if (validDate) {
                SuggestEventDTO dto = new SuggestEventDTO(title, suggestStart, suggestEnd, staffName);
                boolean check = dao.suggestEvent(dto);
                if (check) {
                    url = success;
                } else {
                    request.setAttribute("ERROR", "Suggest Event failed");
                }
            }else{
                url = fail;
                request.setAttribute("INVALID", errObj);
            }

        } catch (Exception e) {
            log("ERROR at SuggestEventController" + e.getMessage());
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
