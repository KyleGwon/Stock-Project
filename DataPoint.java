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
    private Double earnYield; //earnings yield: EBIT / enterprise value
    private Double retCapital; //return on capital: EBIT / net fixed assets + working capital
//    private boolean sortedYield;
    
    //default constructor
    public DataPoint() {
        date = new Date();
        closingPrice = 0.0;
        marketCap = 0.0;
        FQL = 0.0;
        EBIT = 0.0;
        retInvest = 0.0;
        earnYield = 0.0;
        retCapital = 0.0;
//        sortedYield = false;
    }
    
    public DataPoint(Date newDate, Double newPrice, Double newCap, Double newFQL, Double newEBIT, Double newInvest) {
        date = newDate;
        closingPrice = newPrice;
        marketCap = newCap;
        FQL = newFQL;
        EBIT = newEBIT;
        
        if (newInvest.equals(-1.0)) {
//            System.out.println("hi");
            retInvest = -1000.0;
        } else {
            retInvest = newInvest;
        }
        
        if (!(FQL.equals(0.0) || EBIT.equals(-1.0) || FQL.equals(-1.0))) {
            earnYield = EBIT / FQL;
        } else {
            earnYield = -1000.0;
        }
//        sortedYield = false;
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
    public void setYield(Double newYield) {
        earnYield = newYield;
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
    public Double getYield() {
//        System.out.println(EBIT);
//        System.out.println(FQL);
//        System.out.println(EBIT/FQL);

        return earnYield;
    }
    
//    public void changeSort() {
//        sort = !(sort);
//    }
    
    //compareTo helpers
//    public int compareInvest(DataPoint point) {
//        return getInvest().compareTo(point.getInvest());
//    }
//
//    public int compareYield(DataPoint point) {
//        return getYield().compareTo(point.getYield());
//    }
    
    //compareTo method
//    public int compareTo(DataPoint point) {
//        if (sort) {
//            return getInvest().compareTo(point.getInvest());
//        }
//        return getYield().compareTo(point.getYield());
//    }
    
    //toString method
    public String toString() {
        return date + " | " + String.valueOf(closingPrice) + " | " + String.valueOf(marketCap) + " | " + String.valueOf(FQL) + " | " + String.valueOf(EBIT) + " | " + String.valueOf(retInvest) + " | " + String.valueOf(earnYield);
    }
}