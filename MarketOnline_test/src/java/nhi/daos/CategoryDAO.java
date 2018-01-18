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
import nhi.dtos.CategoryDTO;

/**
 *
 * @author admin
 */
public class CategoryDAO implements Serializable{
       private Connection con;
    private PreparedStatement stm;
    private ResultSet rs;

    public CategoryDAO() {
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
    public List<CategoryDTO> getListCategories()throws Exception{
        List<CategoryDTO> list = null;
        try {
            String sql = "select * from Category";
            con = MyConnection.getConnection();
            stm = con.prepareStatement(sql);
//            int id = 0;
//            String name = "";
            list = new ArrayList<>();
            rs = stm.executeQuery();
            while(rs.next()){
                CategoryDTO category = new CategoryDTO();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("category_name"));               
                list.add(category);
            }
            
        } finally{
            closeConnection();
        }
        return list;
    }
}
