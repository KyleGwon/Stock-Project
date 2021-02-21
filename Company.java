package companyPackage;
import java.io.*;
import java.util.ArrayList;
public class Company {
    private String name;
    private String ticker;
    private String assetType;
    private String country;
    private String sector;
    private CompanyData data;
    
    private Date date;
    private boolean option = true;
    
    //default constructor
    public Company() {
        name = "name placeholder";
        ticker = "ticker placeholder";
        assetType = "asset type placeholder";
        country = "country placeholder";
        sector = "sector placeholder";
        data = new CompanyData();
        
        date = new Date();
    }
    
    public Company(String newName, String newTicker, String newType, String newCountry, String newSector, CompanyData newData) {
        name = newName;
        ticker = newTicker;
        assetType = newType;
        country = newCountry;
        sector = newSector;
        data = newData;
        
        date = new Date();
    }
    
    public static void main(String[] args) {
        System.out.println("main function for Company Class");
    }
    
    //checks if company is valid | with the date and market cap
    public boolean isValid() {
        if (sector.equals("Utilities") || sector.equals("Financials") || !(country.equals("United States"))) {
            return false;
        }
        return true;

    }
    //checks if company is valid | with Date
    public boolean isValid(Date date, Double minCap) {
        //note: if point is not generated, then the cap is automatically below the cap since it is -2
        DataPoint point = data.getData(date);
        //if market cap is lower or sector is utility or sector is financial or country is not united states: return false | oherwise return true
        if (point.getCap() < minCap || !(isValid())) {
            return false;
        }
        return true;
    }
    
    //getters
    public CompanyData getCompanyData() {
        return data;
    }
    public String getName() {
        return name;
    }
    public String getTicker() {
        return ticker;
    }
    
//    public Double[] getRankingData(Date date) {
//        Double[] returnData = {data.getData(date).getInvest(), data.getData(date).getYield()};
//        return returnData;
//    }
    
    public void currentDate(Date newDate) {
        date = newDate;
    }
    
    public void currentCompare(boolean newOption) {
        option = newOption;
    }
    
    //compareTo method
    public int compareTo(Company company) {
//        System.out.println(option);
        if (option) {
//            System.out.println(data.compareInvest(date, company.getCompanyData()));
//            System.out.println(this + " " + this.getCompanyData());
            return data.compareInvest(date, company.getCompanyData());
        } else {
            return data.compareYield(date, company.getCompanyData());
        }
    }
    
    //toString method
    public String toString() {
        return name + " | " + ticker + " | " + assetType + " | " + country + " | " + sector;
    }
}