package companyPackage;
import java.io.*;
import java.util.ArrayList;
public class CompanyData {
    private ArrayList<DataPoint> data = new ArrayList<DataPoint>();
    
    //default constructor
    public CompanyData() {}
    
    public static void main(String[] args) {
        System.out.println("main function for CompanyData Class");
    }

    public void addDataPoint(DataPoint newDataPoint) {
        data.add(newDataPoint);
    }
    
    //setters
    public void setData(ArrayList<DataPoint> newData) {
        data = newData;
    }
    
    //getters
    public ArrayList<DataPoint> getData() {
        return data;
    }
    
    //toString method
    public String toString() {
        String returnData = "";
        for (DataPoint point : data) {
            returnData = returnData + point;
        }
        return returnData;
    }
}