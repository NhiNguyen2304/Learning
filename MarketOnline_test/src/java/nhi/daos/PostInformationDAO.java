/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.daos;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nhi.data.MyConnection;
import nhi.dtos.PostInformationDTO;

/**
 *
 * @author admin
 */
public class PostInformationDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public PostInformationDAO() {
    }

    public Connection closeConnection() {
        try {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
     public boolean postEvent(PostInformationDTO dto)throws Exception{
         boolean check = false;
        try {
            String sql = "insert into postInformation (kindOfEvent,postTitle,category_id,postContent,timeToStart,timeToEnd,place,event_image) values (?,?,?,?,?,?,?,?)";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getKindOfEvent());
            stm.setString(2, dto.getTitle());
            stm.setLong(3, dto.getCategoryId());
            stm.setString(4, dto.getContent());
            stm.setDate(5, dto.getDateStart());
            stm.setDate(6, dto.getDateEnd());
            stm.setString(7, dto.getPlace());
            stm.setString(8, dto.getImg());
          check = stm.executeUpdate() > 0;
       
        }finally{
            closeConnection();
        }
        return check;
    }
     public List<PostInformationDTO> loadEvent() throws Exception{
        List<PostInformationDTO> result = null;
         try {
             String sql = "Select kindOfEvent, postTitle, timeToStart, timeToEnd, place From postInformation";
             con = MyConnection.getConnection();
             stm = con.prepareStatement(sql);
             rs = stm.executeQuery();
             
             String eventName = null;
             String title = null;
              Date evStart = null;
              Date evEnd = null;
              String place = null;
              
              result = new ArrayList<>();
              while(rs.next()){
                  eventName = rs.getString("kindOfEvent");
                  title = rs.getString("postTitle");
                  evStart = rs.getDate("timeToStart");
                  evEnd = rs.getDate("timeToEnd");
                  place = rs.getString("place");
                  PostInformationDTO dto = new PostInformationDTO(eventName, title, evStart, evEnd, place);
                  result.add(dto);
              }
             
         } finally{
             closeConnection();
         }
         return result;
     }
     public List<PostInformationDTO> search (String search)throws Exception{
         List<PostInformationDTO> result= null;
         try {
             String sql = "Select kindOfEvent, postTitle, postContent, timeToStart, timeToEnd, status, place From postInformation Where postTitle LIKE ?";
             con = MyConnection.getConnection();
             stm = con.prepareStatement(sql);
             stm.setString(1, "%" + search + "%");
             
              String eventName = null;
             String title = null;
             String content = null;
              Date evStart = null;
              Date evEnd = null;
              String status = null;
              String place = null;
              rs = stm.executeQuery();
             result = new ArrayList<>();
              while(rs.next()){
                  eventName = rs.getString("kindOfEvent");
                  title = rs.getString("postTitle");
                  content = rs.getString("postContent");
                  evStart = rs.getDate("timeToStart");
                  evEnd = rs.getDate("timeToEnd");
                  status = rs.getString("status");
                  place = rs.getString("place");
                  PostInformationDTO dto = new PostInformationDTO(eventName, title, content, status, place, evStart, evEnd);
                  result.add(dto);
              }
         }finally{
             closeConnection();
         }
         return result;
     }
     public PostInformationDTO findByPrimaryKey(String pk)throws Exception{
         PostInformationDTO dto = null;
         try {
             String sql = "Select kindOfEvent, postTitle, postContent, timeToStart, timeToEnd, status, place From postInformation Where postTitle = ?";
             con = MyConnection.getConnection();
             stm = con.prepareStatement(sql);
             stm.setString(1, pk);
             rs = stm.executeQuery();
             if(rs.next()){
                String eventName = rs.getString("kindOfEvent");
                String  title = rs.getString("postTitle");
                String  content = rs.getString("postContent");
                 Date evStart = rs.getDate("timeToStart");
                 Date evEnd = rs.getDate("timeToEnd");
                 String status = rs.getString("status");
                 String place = rs.getString("place");
                 dto = new PostInformationDTO(eventName, title, content, status, place, evStart, evEnd);
             }
         } finally{
             closeConnection();
         }
         return dto;
     }
     
  
     public boolean updateEvent(PostInformationDTO dto)throws Exception{
        
         try {
             String sql = "Update postInformation set kindOfEvent = ?,"
                     + "postContent = ?, timeToStart = ?, timeToEnd = ?, status = ?, place = ? Where postTitle = ?";
             con = MyConnection.getConnection();
             stm = con.prepareStatement(sql);
             stm.setString(1, dto.getKindOfEvent());
            // stm.setString(2, dto.getTitle());
             stm.setString(2, dto.getContent());
             stm.setDate(3, dto.getDateStart());
             stm.setDate(4, dto.getDateEnd());
             stm.setString(5, dto.getStatus());
             stm.setString(6, dto.getPlace());
             stm.setString(7, dto.getTitle());
             int row = stm.executeUpdate();
             if(row > 0){
                 return true;
             }
         } finally{
             closeConnection();
         }
         return false;
     }
     
     public ArrayList<PostInformationDTO> getListEventByCategory(long categoryId)throws Exception{
         ArrayList<PostInformationDTO> listEvent = null;
         try {
             String sql = "Select kindOfEvent, postTitle, postContent, timeToStart, "
                     + "timeToEnd, status, place, category_id, event_image From postInformation WHERE category_id = ?";
              con = MyConnection.getConnection();
             stm = con.prepareStatement(sql);
             stm.setLong(1, categoryId);
              rs = stm.executeQuery();
              listEvent = new ArrayList<>();
              while(rs.next()){
                  PostInformationDTO dto = new PostInformationDTO();
                  dto.setTitle(rs.getString("postTitle"));
                 dto.setKindOfEvent(rs.getString("kindOfEvent"));
                  dto.setCategoryId(rs.getLong("category_id"));
                  dto.setContent(rs.getString("postContent"));
                  dto.setDateStart(rs.getDate("timeToStart"));
                  dto.setDateEnd(rs.getDate("timeToEnd"));
                  dto.setStatus(rs.getString("status"));
                  dto.setPlace(rs.getString("place"));
                  dto.setImg(rs.getString("event_image"));
                  listEvent.add(dto);
              }
         } finally {
             closeConnection();
         }
         return listEvent;
     }
}
