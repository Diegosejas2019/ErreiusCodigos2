package com.erreius.developer.dev2018.Model;

public class EncryptData {
    public String EmailEmployee;
    public String Message;
    public String EUS;
    public String EPS;
    public String ErrorMessage;
    public Integer StatusCode;

    public EncryptData() {
    }

    public String getEmailEmployee() {
        return EmailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        EmailEmployee = emailEmployee;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getEUS() {
        return EUS;
    }

    public void setEUS(String EUS) {
        this.EUS = EUS;
    }

    public String getEPS() {
        return EPS;
    }

    public void setEPS(String EPS) {
        this.EPS = EPS;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        ErrorMessage = errorMessage;
    }

    public Integer getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(Integer statusCode) {
        StatusCode = statusCode;
    }
}
