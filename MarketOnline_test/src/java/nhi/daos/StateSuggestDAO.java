/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nhi.data.MyConnection;
import nhi.dtos.StateSuggestDTO;

/**
 *
 * @author admin
 */
public class StateSuggestDAO implements Serializable {

    private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    private Connection closeConnection() throws Exception {
       if(rs != null){
           rs.close();
       }
       if(stm != null){
           stm.close();
       }
       if(con != null){
           con.close();
       }
        return con;
    }
    public boolean saveState(StateSuggestDTO dto) throws Exception{
        boolean check = false;
        try {
            String sql = "insert into JudgeSuggest (state,note,titleSugg,maker) values (?,?,?,?)";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getState());
            stm.setString(2, dto.getNote());
            stm.setString(3, dto.getTitleSug());
            stm.setString(4, dto.getMaker());
            
            check = stm.executeUpdate() > 0;
        } finally{
            closeConnection();
        }
        return check;
    }
    public List<StateSuggestDTO> loadJudged()throws Exception{
        List<StateSuggestDTO> result = null;
        try {
            String sql = "Select state, note, titleSugg, maker from JudgeSuggest";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
            String state = null;
            String note = null;
            String titile = null;
            String maker = null;
            rs = stm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()){
                state = rs.getString("state");
                note = rs.getString("note");
                titile = rs.getString("titleSugg");
                maker = rs.getString("maker");
                StateSuggestDTO dto = new StateSuggestDTO(state, note, titile, maker);
                result.add(dto);
            }
        } finally{
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
}
