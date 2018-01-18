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
public class SuggestEventErrObj implements Serializable{
    private String dateStartSugErr, dateEndSuggEr;

    public SuggestEventErrObj() {
    }

    public String getDateStartSugErr() {
        return dateStartSugErr;
    }

    public void setDateStartSugErr(String dateStartSugErr) {
        this.dateStartSugErr = dateStartSugErr;
    }

    public String getDateEndSuggEr() {
        return dateEndSuggEr;
    }

    public void setDateEndSuggEr(String dateEndSuggEr) {
        this.dateEndSuggEr = dateEndSuggEr;
    }
    
}
