/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nhi.data.MyConnection;
import nhi.dtos.SuggestEventDTO;

/**
 *
 * @author admin
 */
public class SuggestEventDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    private Connection closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean suggestEvent(SuggestEventDTO dto) {
        boolean check = false;
        try {
            String sql = "insert into EventSuggest (eventSugTitle,timeSugStart,timeSugEnd,maker) values (?,?,?,?)";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getTitleSug());
            stm.setDate(2, dto.getTimeStartSug());
            stm.setDate(3, dto.getTimeEndSug());
            stm.setString(4, dto.getMaker());
            check = stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    //load suggest not with key, button view all suggest
    public List<SuggestEventDTO> loadSuggestEvent() throws Exception {
        List<SuggestEventDTO> result = null;
        try {
            String sql = "Select eventSugTitle, timeSugStart, timeSugEnd, maker From EventSuggest";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);

            rs = stm.executeQuery();

            String sugTitle = null;
            Date sugStart = null;
            Date sugEnd = null;
            String maker = null;

            result = new ArrayList<>();
            while (rs.next()) {
                sugTitle = rs.getString("eventSugTitle");
                sugStart = rs.getDate("timeSugStart");
                sugEnd = rs.getDate("timeSugEnd");
                maker = rs.getString("maker");
                
                SuggestEventDTO dto = new SuggestEventDTO(sugTitle, sugStart, sugEnd, maker);
                result.add(dto);
            }

        } finally {
            closeConnection();
        }
        return result;
    }
        public List<SuggestEventDTO> loadSuggestEventWithKey(String name) throws Exception {
        List<SuggestEventDTO> result = null;
        try {
            String sql = "Select eventSugTitle, timeSugStart, timeSugEnd, status, maker From EventSuggest Where maker = ?";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();

            String sugTitle = null;
            Date sugStart = null;
            Date sugEnd = null;
            String status = null;
            String maker = null;

            result = new ArrayList<>();
            while (rs.next()) {
                sugTitle = rs.getString("eventSugTitle");
                sugStart = rs.getDate("timeSugStart");
                sugEnd = rs.getDate("timeSugEnd");
                status = rs.getString("status");
                maker = rs.getString("maker");
                
                SuggestEventDTO dto = new SuggestEventDTO(sugTitle, sugStart, sugEnd, maker, status);
                result.add(dto);
            }

        } finally {
            closeConnection();
        }
        return result;
    }
    
    //Load suggest in another page and with key to search
    public List<SuggestEventDTO> loadSuggestEvent(String loadData) throws Exception {
        List<SuggestEventDTO> result = null;
        try {
            String sql = "Select eventSugTitle, timeSugStart, timeSugEnd From EventSuggest Where eventSugTitle LIKE ?";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + loadData + "%");
            rs = stm.executeQuery();

            String sugTitle = null;
            Date sugStart = null;
            Date sugEnd = null;

            result = new ArrayList<>();
            while (rs.next()) {
                sugTitle = rs.getString("eventSugTitle");
                sugStart = rs.getDate("timeSugStart");
                sugEnd = rs.getDate("timeSugEnd");
                SuggestEventDTO dto = new SuggestEventDTO(sugTitle, sugStart, sugEnd);
                result.add(dto);
            }

        } finally {
            closeConnection();
        }
        return result;
    }

    public SuggestEventDTO findByPrimaryKey(String pk) throws Exception {
        SuggestEventDTO dto = null;

        try {
            String sql = "Select eventSugTitle, timeSugStart, timeSugEnd From EventSuggest Where eventSugTitle = ?";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, pk);
            rs = stm.executeQuery();

            String sugTitle = null;
            Date sugStart = null;
            Date sugEnd = null;
            if (rs.next()) {
                sugTitle = rs.getString("eventSugTitle");
                sugStart = rs.getDate("timeSugStart");
                sugEnd = rs.getDate("timeSugEnd");
                dto = new SuggestEventDTO(sugTitle, sugStart, sugEnd);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
     public boolean delete(String maker) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From EventSuggest Where maker = ?";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, maker);
            check = stm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    

//    public boolean delete(String title) throws Exception {
//        boolean check = false;
//        try {
//            String sql = "Delete From EventSuggest Where eventSugTitle = ?";
//            con = MyConnection.getConnection();
//            stm = con.prepareStatement(sql);
//            stm.setString(1, title);
//            check = stm.executeUpdate() > 0;
//        } finally {
//            closeConnection();
//        }
//        return check;
//    }

    public List<SuggestEventDTO> search(String search) throws Exception {
        List<SuggestEventDTO> result = null;
        try {
            String sql = "Select eventSugTitle, timeSugStart, timeSugEnd, maker From EventSuggest Where eventSugTitle LIKE ?";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            String sugTitle = null;
            Date sugStart = null;
            Date sugEnd = null;
            String maker = null;
            result = new ArrayList<>();
            while (rs.next()) {
                sugTitle = rs.getString("eventSugTitle");
                sugStart = rs.getDate("timeSugStart");
                sugEnd = rs.getDate("timeSugEnd");
                maker = rs.getString("maker");
                SuggestEventDTO dto = new SuggestEventDTO(sugTitle, sugStart, sugEnd, maker);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    public boolean updateStatus(String status, String title)throws Exception{
      boolean check = false;
        try {
            int row = 0;
            String sql = "Update EventSuggest set status = ? Where eventSugTitle = ?";
             con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
             stm.setString(1, status);
            stm.setString(2, title);
            row = stm.executeUpdate();
            if(row > 0){
                check = true;
            }
        } finally{
            closeConnection();
        }
        return check;
    }
    
     public String findStatus() throws Exception {
        String status = null;

        try {
            String sql = "Select status From EventSuggest";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            
            if (rs.next()) {
             status = rs.getString("status");
               
            }
        } finally {
            closeConnection();
        }
        return status;
    }
     public int countTheAction(String name)throws Exception{
         int count = 0;
         try {
             String sql = "SELECT COUNT(eventSugTitle) FROM EventSuggest where maker = ?";
             con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, name);
            rs = stm.executeQuery();
            if(rs.next()){
                //count = rs.getC;
            }
           
             
         } catch (Exception e) {
             closeConnection();
         }
         return count;
     }

}
