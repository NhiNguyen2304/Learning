/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.dtos;

import java.awt.Image;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import microsoft.sql.DateTimeOffset;

/**
 *
 * @author admin
 */
    public class PostInformationDTO implements Serializable{
    private int idEvent;
    private String kindOfEvent, title, content,status, place;
    private Date dateStart, dateEnd;
    private String img;
    private long categoryId;

    

    public PostInformationDTO() {
    }

    public PostInformationDTO(String title, String content, String status, String place, Date dateStart, Date dateEnd) {
        this.title = title;
        this.content = content;
        this.status = status;
        this.place = place;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    
    
    
     public PostInformationDTO(String kindOfEvent, String title, String content, Date dateStart, Date dateEnd, String place, String image) {
       this.kindOfEvent = kindOfEvent;
        this.title = title;
       this.content = content;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.place = place;
        this.img = image;
    }

      public PostInformationDTO(String kindOfEvent, String title, String content, Date dateStart, Date dateEnd, String place) {
       this.kindOfEvent = kindOfEvent;
        this.title = title;
       this.content = content;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.place = place;
    
    }
    public PostInformationDTO(String kindOfEvent, String title, String content, String status, String place, Date dateStart, Date dateEnd) {
        this.kindOfEvent = kindOfEvent;
        this.title = title;
        this.content = content;
        this.status = status;
        this.place = place;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
     
 public PostInformationDTO(String kindOfEvent, String title, Date dateStart, Date dateEnd, String place) {
       this.kindOfEvent = kindOfEvent;
        this.title = title;
       this.content = content;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.place = place;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }
 

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }
    

    public String getKindOfEvent() {
        return kindOfEvent;
    }

    public void setKindOfEvent(String kindOfEvent) {
        this.kindOfEvent = kindOfEvent;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

}