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
public class RegistrationErrorObj implements Serializable{
    private String usernameErr, passwordErr, fullnameErr, roleErr, confirmErr;
    private String usernameExisted;

    public RegistrationErrorObj() {
    }

    public String getUsernameExisted() {
        return usernameExisted;
    }

    public void setUsernameExisted(String usernameExisted) {
        this.usernameExisted = usernameExisted;
    }

    
    public String getConfirmErr() {
        return confirmErr;
    }

    public void setConfirmErr(String confirmErr) {
        this.confirmErr = confirmErr;
    }

    
    

    public String getUsernameErr() {
        return usernameErr;
    }

    public void setUsernameErr(String usernameErr) {
        this.usernameErr = usernameErr;
    }

    public String getPasswordErr() {
        return passwordErr;
    }

    public void setPasswordErr(String passwordErr) {
        this.passwordErr = passwordErr;
    }

    public String getFullnameErr() {
        return fullnameErr;
    }

    public void setFullnameErr(String fullnameErr) {
        this.fullnameErr = fullnameErr;
    }

    public String getRoleErr() {
        return roleErr;
    }

    public void setRoleErr(String roleErr) {
        this.roleErr = roleErr;
    }
    
}
