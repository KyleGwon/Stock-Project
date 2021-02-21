package companyPackage;
import java.io.*;
import java.util.ArrayList;
//date notation of month/day/year
public class Date {
    private int year;
    private int month;
    private int day;
    
    //default constructor
    public Date() {
        month = 1;
        day = 1;
        year = 1;
    }
    
    //constructor: takes in date as a String in proper date notation
    public Date(String newDate) {
        addStringDate(newDate);
    }
    
    //constructor: takes in date as three integers of day, month, and year
    public Date(int newDay, int newMonth, int newYear) {
        day = newDay;
        month = newMonth;
        year = newYear;
    }
    
    public static void main(String[] args) {
        System.out.println("main function for Date Class");
    }

    //helper function: date constructor with string parameter | setDate function
    private void addStringDate(String newDate) {
        month = Integer.parseInt(newDate.substring(0, newDate.indexOf("/")));
        newDate = newDate.substring(newDate.indexOf("/")+1, newDate.length());
        day = Integer.parseInt(newDate.substring(0, newDate.indexOf("/")));
        newDate = newDate.substring(newDate.indexOf("/")+1, newDate.length());
        year = Integer.parseInt(newDate);
    }
    
    //setters
    public void setDate(String newDate) {
        addStringDate(newDate);
    }
    
    //getters
    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public String getFullDate() {
        return String.valueOf(month) + "/" + String.valueOf(day) + "/" + String.valueOf(year);
    }
    
    //toString method
    public String toString() {
        return getFullDate();
    }
}