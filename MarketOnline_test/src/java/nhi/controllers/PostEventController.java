/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.controllers;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nhi.daos.PostInformationDAO;
import nhi.daos.StateSuggestDAO;
import nhi.daos.SuggestEventDAO;
import nhi.dtos.PostInformationDTO;
import nhi.dtos.PostInformationDTOErrObj;
import nhi.dtos.StateSuggestDTO;
import nhi.dtos.SuggestEventDTO;

/**
 *
 * @author admin
 */
public class PostEventController extends HttpServlet {

    private final String error = "error.jsp";
    private final String success = "adminPost.jsp";
    private final String fail = "adminPost.jsp";


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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        String url = error;
        try {
            HttpSession session = request.getSession();
            PostInformationDAO dao = new PostInformationDAO();
            SuggestEventDAO daoSug = new SuggestEventDAO();
            StateSuggestDAO daoState = new StateSuggestDAO();
            String action = request.getParameter("action");
            if (action.equals("Agree")) {
                String titleSugg = request.getParameter("txtTitileSug");
                //save Status
                String status = "Agree";
                String note = "";
                SuggestEventDTO dto = daoSug.findByPrimaryKey(titleSugg);
                request.setAttribute("INFO", dto);
                //   session.setAttribute("TITLE", titleSugg);
                StateSuggestDTO dtoState = new StateSuggestDTO(status, note, titleSugg);
                boolean check = daoState.saveState(dtoState);
                boolean checkUpdate = daoSug.updateStatus(status, note);
                if (check && checkUpdate) {
                    url = success;
                } else {
                    request.setAttribute("ERROR", "Can't update");
                }

            }
            if (action.equals("Post")) {
                PostInformationDTO dto = new PostInformationDTO();
                //String kindOfEvent = request.getParameter("txtKindEvent");
                String item = request.getParameter("listKind");
                String[] tmp = item.split("-");
                dto.setCategoryId(Long.parseLong(tmp[0]));
                dto.setKindOfEvent(tmp[1]);

                String place = request.getParameter("txtPlace");
                dto.setPlace(place);

                String title = request.getParameter("txtTitle");
                dto.setTitle(title);

                boolean validDate = true;
                PostInformationDTOErrObj errObj = new PostInformationDTOErrObj();
                Date temp = Date.valueOf(LocalDate.now());

                String start = request.getParameter("txtTimeStart");
                Date dateStart = Date.valueOf(start);
                dto.setDateStart(dateStart);
                if (temp.after(dateStart)) {
                    validDate = false;
                    errObj.setDateStartErr("Date start was passed");
                }

                String end = request.getParameter("txtTimeEnd");
                Date dateEnd = Date.valueOf(end);
                if (temp.after(dateEnd)) {
                    validDate = false;
                    errObj.setDateEndErr("Date end was passed");
                }
                dto.setDateEnd(dateEnd);



                    String fileImg = request.getParameter("txtImage");
                    dto.setImg(fileImg);

                    String content = request.getParameter("txtContent");
                    dto.setContent(content);
                    if (validDate) {
                        boolean check = dao.postEvent(dto);
                        if (check) {
                            url = success;
                        } else {
                            request.setAttribute("ERROR", "Post Event failed");
                        }
                    } else {
                        url = fail;
                        request.setAttribute("INVALID", errObj);
                    }

                }
            }catch (Exception e) {
                
            log("ERROR at PostEventController" + e.getMessage());
        }finally {
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PostEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PostEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
