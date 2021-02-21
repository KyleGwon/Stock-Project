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
    
    public DataPoint getData(Date date) {
        for (DataPoint point : data) {
            if (point.getDate().getFullDate().equals(date.getFullDate())) {
                return point;
            }
        }
        return new DataPoint(date, -2.0, -2.0, -2.0, -2.0, -2.0);
    }
    
    public int compareInvest(Date date, CompanyData otherData) {
        DataPoint thisPoint = new DataPoint();
        DataPoint otherPoint = new DataPoint();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getDate().getFullDate().equals(date.getFullDate())) {
                thisPoint = data.get(i);
//                System.out.println(otherData.getData().get(i));
                otherPoint = otherData.getData().get(i);
            }
        }
//        for (DataPoint point : data) {
//            if (point.getDate().getFullDate().equals(date.getFullDate())) {
//                thisPoint = point;
//            }
//        }
//        System.out.println(thisPoint.getInvest());
//        System.out.println(otherPoint.getInvest());
//        System.out.println("hello");
        return thisPoint.getInvest().compareTo(otherPoint.getInvest());
//        return thisPoint.compareInvest(otherPoint)
    }

    public int compareYield(Date date, CompanyData otherData) {
        DataPoint thisPoint = new DataPoint();
        DataPoint otherPoint = new DataPoint();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getDate().getFullDate().equals(date.getFullDate())) {
                thisPoint = data.get(i);
                otherPoint = otherData.getData().get(i);
            }
        }
        return thisPoint.getYield().compareTo(otherPoint.getYield());
//        return thisPoint.compareYield(otherPoint)
    }

    //toString method
    public String toString() {
        String returnData = "";
        for (DataPoint point : data) {
            returnData = returnData + point + "    ";
        }
        return returnData;
    }
}