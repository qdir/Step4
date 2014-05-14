package es.unileon.springapp.domain;

import java.io.Serializable;

public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    private String date;
    private Double fee;
    
    public String getDate() {
        return date;
    }
    
    public void setDate(String date) {
        this.date = date;
    }
    
    public Double getFee() {
        return fee;
    }
    
    public void setFee(Double price) {
        this.fee = price;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Date: " + date + ";");
        buffer.append("Fee: " + fee);
        return buffer.toString();
    }
}