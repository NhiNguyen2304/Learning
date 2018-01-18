/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nhi.daos.RegistrationDAO;
import nhi.dtos.RegistrationDTO;
import nhi.dtos.RegistrationErrorObj;

/**
 *
 * @author admin
 */
public class RegisterAcountController extends HttpServlet {
private final String error = "error.jsp";
private final String success = "loginPage.jsp";
private final String failed = "register.jsp";
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
           
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String fullname = request.getParameter("txtFullname");
            String role = request.getParameter("txtRole");
            RegistrationErrorObj errObj = new RegistrationErrorObj();
            RegistrationDAO dao = new RegistrationDAO();
            
            boolean checkUsername = false;
            checkUsername = dao.findByPrimaryKey(username);
            
            boolean valid = true;
            if(username.length() < 3){
                errObj.setUsernameErr("Username can't be less than 3 chars");
                valid = false;
            }
            if(checkUsername){
                errObj.setUsernameExisted("Username was existed");
                valid = false;
            }
            
            if(password.length() < 3){
               errObj.setPasswordErr("Password can't be blank");
            }
            if(!confirm.trim().equals(password.trim())){
                errObj.setConfirmErr("Confirm not match");
                valid = false;
            }
            if(valid){
                RegistrationDTO dto = new RegistrationDTO(username, fullname, role);
                dto.setPassword(password);
                boolean check = false;
                check = dao.registerAcount(dto);
                if(check){
                    
                     url = success;
                }else{
                    url = failed;
                    request.setAttribute("ERROR", "Can't registration");
                }
               
            }else{
                url = failed;
                request.setAttribute("INVALID", errObj);
            }
            
            
        } catch (Exception e) {
            log("ERROR at RegisterAcountController " +e.getMessage());
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
