/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author admin
 */
public class PostInformationDTOErrObj implements Serializable{
    private String dateStartErr, dateEndErr;

    public PostInformationDTOErrObj() {
    }

    public String getDateStartErr() {
        return dateStartErr;
    }

    public void setDateStartErr(String dateStartErr) {
        this.dateStartErr = dateStartErr;
    }

    public String getDateEndErr() {
        return dateEndErr;
    }

    public void setDateEndErr(String dateEndErr) {
        this.dateEndErr = dateEndErr;
    }
    
}
