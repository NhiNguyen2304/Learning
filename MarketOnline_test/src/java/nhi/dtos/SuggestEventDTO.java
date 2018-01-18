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
public class SuggestEventDTO implements Serializable{
    private String idSugg;
    private String titleSug;
    private Date timeStartSug;
    private Date timeEndSug;
    private String maker;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public SuggestEventDTO() {
    }

    public SuggestEventDTO(String titleSug, Date timeStartSug, Date timeEndSug) {
        this.titleSug = titleSug;
        this.timeStartSug = timeStartSug;
        this.timeEndSug = timeEndSug;
    }
    
    //this cons for save suggest have staff's name

    public SuggestEventDTO(String titleSug, Date timeStartSug, Date timeEndSug, String maker) {
        this.titleSug = titleSug;
        this.timeStartSug = timeStartSug;
        this.timeEndSug = timeEndSug;
        this.maker = maker;
    }

    public SuggestEventDTO(String titleSug, Date timeStartSug, Date timeEndSug, String maker, String status) {
        this.titleSug = titleSug;
        this.timeStartSug = timeStartSug;
        this.timeEndSug = timeEndSug;
        this.maker = maker;
        this.status = status;
    }
    
    
    
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getTitleSug() {
        return titleSug;
    }

    public void setTitleSug(String titleSug) {
        this.titleSug = titleSug;
    }

    public Date getTimeStartSug() {
        return timeStartSug;
    }

    public void setTimeStartSug(Date timeStartSug) {
        this.timeStartSug = timeStartSug;
    }

    public Date getTimeEndSug() {
        return timeEndSug;
    }

    public void setTimeEndSug(Date timeEndSug) {
        this.timeEndSug = timeEndSug;
    }

    public String getIdSugg() {
        return idSugg;
    }

    public void setIdSugg(String idSugg) {
        this.idSugg = idSugg;
    }
    
}
