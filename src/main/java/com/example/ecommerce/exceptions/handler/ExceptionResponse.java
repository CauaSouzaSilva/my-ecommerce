package com.example.ecommerce.exceptions.handler;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 902374196L;

    private Date timestamp;
    private String massage;
    private String datails;

    public ExceptionResponse(Date timestamp, String massage, String datails) {
        this.timestamp = timestamp;
        this.massage = massage;
        this.datails = datails;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMassage() {
        return this.massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getDatails() {
        return this.datails;
    }

    public void setDatails(String datails) {
        this.datails = datails;
    }

}
