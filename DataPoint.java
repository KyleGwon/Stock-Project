package companyPackage;
import java.io.*;
import java.util.ArrayList;
public class DataPoint {
    private Date date; //Date class
    private Double closingPrice; //closing price
    private Double marketCap; //market capitalization in millions
    private Double FQL; //enterprise value
    private Double EBIT; //EBIT in last twelve months
    private Double retInvest; //return on investment
    
    //default constructor
    public DataPoint() {
        date = new Date();
        closingPrice = 0.0;
        marketCap = 0.0;
        FQL = 0.0;
        EBIT = 0.0;
        retInvest = 0.0;
    }
    
    public DataPoint(Date newDate, Double newPrice, Double newCap, Double newFQL, Double newEBIT, Double newInvest) {
        date = newDate;
        closingPrice = newPrice;
        marketCap = newCap;
        FQL = newFQL;
        EBIT = newEBIT;
        retInvest = newInvest;
    }
    
    public static void main(String[] args) {
        System.out.println("main function for DataPoint Class");
    }

    //setters
    public void setDate(Date newDate) {
        date = newDate;
    }
    public void setPrice(Double newPrice) {
        closingPrice = newPrice;
    }
    public void setCap(Double newCap) {
        marketCap = newCap;
    }
    public void setFQL(Double newFQL) {
        FQL = newFQL;
    }
    public void setEBIT(Double newEBIT) {
        EBIT = newEBIT;
    }
    public void setInvest(Double newInvest) {
        retInvest = newInvest;
    }
    
    //getters
    public Date getDate() {
        return date;
    }
    public Double getPrice() {
        return closingPrice;
    }
    public Double getCap() {
        return marketCap;
    }
    public Double getFQL() {
        return FQL;
    }
    public Double getEBIT() {
        return EBIT;
    }
    public Double getInvest() {
        return retInvest;
    }
    
    //toString method
    public String toString() {
        return date + " | " + String.valueOf(closingPrice) + " | " + String.valueOf(marketCap) + " | " + String.valueOf(FQL) + " | " + String.valueOf(EBIT) + " | " + String.valueOf(retInvest);
    }
}