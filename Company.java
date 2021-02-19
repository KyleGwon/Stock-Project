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
    
    //default constructor
    public Company() {
        name = "name placeholder";
        ticker = "ticker placeholder";
        assetType = "asset type placeholder";
        country = "country placeholder";
        sector = "sector placeholder";
        data = new CompanyData();
    }
    
    public Company(String newName, String newTicker, String newType, String newCountry, String newSector, CompanyData newData) {
        name = newName;
        ticker = newTicker;
        assetType = newType;
        country = newCountry;
        sector = newSector;
        data = newData;        
    }
    
    public static void main(String[] args) {
        System.out.println("main function for Company Class");
    }
    
    //toString method
    public String toString() {
        return name + " | " + ticker + " | " + assetType + " | " + country + " | " + sector;
    }
}