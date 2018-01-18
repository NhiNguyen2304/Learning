/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhi.daos.PostInformationDAO;
import nhi.dtos.PostInformationDTO;

/**
 *
 * @author admin
 */
public class UpdateEventController extends HttpServlet {

    private final String error = "error.jsp";
    private final String update = "updateEvent.jsp";
    private final String success = "viewEvent.jsp";

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
            String action = request.getParameter("action");
            PostInformationDAO dao = new PostInformationDAO();
            if (action.equals("Edit")) {
                String title = request.getParameter("txtTitle");
                PostInformationDTO dto = dao.findByPrimaryKey(title);
                request.setAttribute("DTO", dto);
                url = update;
            } else {
                String kindOfEvent = request.getParameter("txtKindEvent");
                String place = request.getParameter("txtPlace");
                String title = request.getParameter("txtTitle");
                String start = request.getParameter("txtTimeStart");
                Date dateStart = Date.valueOf(start);
                String end = request.getParameter("txtTimeEnd");
                Date dateEnd = Date.valueOf(end);
                String content = request.getParameter("txtContent");
                String status = request.getParameter("txtStatus");
                PostInformationDTO dto = new PostInformationDTO(kindOfEvent, title, content, status, place, dateStart, dateEnd);
                boolean check = dao.updateEvent(dto);
                if (check) {
                    url = success;
                } else {
                    request.setAttribute("ERROR", "Can't update");
                }
            }
        } catch (Exception e) {
            log("ERROR at UpdateEventController " +e.getMessage());
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
