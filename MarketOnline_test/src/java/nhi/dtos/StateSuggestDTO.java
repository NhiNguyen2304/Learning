/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhi.dtos;

import java.io.Serializable;

/**
 *
 * @author admin
 */
public class StateSuggestDTO implements Serializable{
    private String state, note, titleSug, maker;

    public StateSuggestDTO(String state, String note, String titleSug) {
        this.state = state;
        this.note = note;
        this.titleSug = titleSug;
       
    }
    public StateSuggestDTO(String state, String note, String titleSug, String maker) {
        this.state = state;
        this.note = note;
        this.titleSug = titleSug;
        this.maker = maker;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

   

    public StateSuggestDTO() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTitleSug() {
        return titleSug;
    }

    public void setTitleSug(String titleSug) {
        this.titleSug = titleSug;
    }
    
}
