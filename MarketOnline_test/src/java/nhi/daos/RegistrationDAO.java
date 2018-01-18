/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.daos;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import nhi.data.MyConnection;
import nhi.dtos.RegistrationDTO;

/**
 *
 * @author admin
 */
public class RegistrationDAO implements Serializable {

    private Connection conn;
    private PreparedStatement stm;
    private ResultSet rs;

    public RegistrationDAO() {
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String checkLogin(String username, String password) throws Exception {
         String role = "failed";
        try {
            String sql = "select Role from Registration where Username = ? and Password = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) {
                role = rs.getString("Role");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
   public boolean registerAcount(RegistrationDTO dto)throws Exception{
       boolean check = false;
       try {
           String sql = "insert into Registration (Username,Password,Fullname,Role) values (?,?,?,?)";
           conn = MyConnection.getConnection();
           stm = conn.prepareStatement(sql);
           stm.setString(1, dto.getUsername());
           stm.setString(2, dto.getPassword());
           stm.setString(3, dto.getFullname());
           stm.setString(4, dto.getRole());
         check = stm.executeUpdate() > 0;
           
       } finally{
           closeConnection();
       }
       return check;
   }
   public boolean findByPrimaryKey(String pk)throws Exception{
       boolean check = false;
       try {
           String sql = "Select Username From Registration Where Username = ?";
           conn = MyConnection.getConnection();
           stm = conn.prepareStatement(sql);
           stm.setString(1, pk);
          rs = stm.executeQuery();
          if(rs.next()){
              check = true;
          }
       } finally{
           closeConnection();
       }
       return check;
   }
     public boolean delete(String username)throws Exception{
        boolean check = false;
        try {
            String sql = "Delete From Registration where Username = ?";
            conn = MyConnection.getConnection();
            stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
