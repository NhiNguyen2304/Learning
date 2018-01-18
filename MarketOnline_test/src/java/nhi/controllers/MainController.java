/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class MainController extends HttpServlet {
private static final String error = "error.jsp";
private static final String login = "LoginController";
private static final String logout = "LogoutController";
private static final String postEvent = "PostEventController";
private static final String sugEvent = "SuggestEventController";
private static final String loadSuggEvent = "LoadSuggestEventController";
private static final String loadSuggEventJudged = "LoadSuggestJudgedController";
private static final String disagreeSugg = "DisagreeSuggestEventController";
private static final String deleteSugg = "DeleteSuggestController";
private static final String searchSugg = "SearchSuggestController";
private static final String searchEvent = "SearchEventController";
private static final String updateEvent = "UpdateEventController";
private static final String registerAcount = "RegisterAcountController";
private static final String sortEvent = "SortEventController";



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
         
            if(action.equals("Login")){
                url = login;
            }else if(action.equals("Post") || action.equals("Agree")){            
               url = postEvent;
            }else if(action.equals("Suggest")){
                url = sugEvent;           
            }else if(action.equals("Disagree")){
                url = disagreeSugg;
            }else if(action.equals("Delete")){
                url = deleteSugg;
            }else if(action.equals("SearchSuggest")){ //search Suggest 
                url = searchSugg;
            }else if(action.equals("Load")  || action.equals("LoadYour")){
                url = loadSuggEvent;
            }else if(action.equals("SearchEvent")){
                url = searchEvent;
            }else if(action.equals("Edit") || action.equals("Update")){              
                url = updateEvent;
            }else if(action.equals("Register")){
                url = registerAcount;
            }else if(action.equals("LoadJudged")){
                url = loadSuggEventJudged;
            }else if(action.equals("Update") || action.equals("Edit")){
                url = updateEvent;
            }else if(action.equals("Logout")){
                url = logout;
            }else if(action.equals("Sort")){
                url = sortEvent;
            }

        } catch (Exception e) {
           
            log("ERROR at MainController" + e.getMessage());
        }finally{
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
