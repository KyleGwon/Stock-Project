import companyPackage.Date;
import companyPackage.DataPoint;
import companyPackage.Company;
import companyPackage.CompanyData;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class stonk {
    public stonk() {}
    public static void main(String[] args) throws FileNotFoundException {
        parseData();
    }
    private static void parseData() throws FileNotFoundException {
        File file = new File("C:\\Users\\Kyle\\Documents\\Brackets-Files\\data.csv");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter(",");
        String line;
        String[] splitLine;
        String[] essentialData = new String[5];
        int essentialCounter;
        ArrayList<Date> dates = new ArrayList<Date>();
        ArrayList<DataPoint> tempDataArray;
        CompanyData newCompanyData;
        ArrayList<Company> companies = new ArrayList<Company>();
        boolean startOfNum;
        boolean startOfString;
        boolean endNum;
        String num;
        String tempString;
        int counter;
        Double[] tempData = new Double[5];
        int dateCounter;
        
        while (scanner.hasNextLine()) {
//        for (int i = 0; i < 11; i++) {
//            System.out.println("check 1");
            line = scanner.nextLine();
            splitLine = line.split(",");
            
            
            if (splitLine.length > 1) {
                dateCounter = 0;
                startOfNum = false;
                startOfString = false;
                endNum = false;
                num = "";
                tempString = "";
                counter = 0;
                essentialCounter = 0;
                tempDataArray = new ArrayList<DataPoint>();
                for (String col : splitLine) {
                    
                    if (col.equals("Ticker")) {
                        break;
                    }
                    
                    if (counter < 5) {
//                        System.out.println(col);
//                        System.out.println(tempString);
                        if (col.indexOf("\"") == -1 && startOfString == false) {
                            essentialData[counter] = col;
                            counter++;
                        }
                        else if (col.indexOf("\"") == 0) {
                            startOfString = true;
                            tempString = col.substring(1);
                        }
                        else if (col.indexOf("\"") == col.length()-1) {
                            essentialData[counter] = tempString + col.substring(0, col.length()-1);
                            startOfString = false;
                            counter++;
                        } else {
                            tempString = tempString + col;
                        }
                    }
                    
                //if it is a date
                    else if (!(col.indexOf("/") == -1)) {
                        
                        //add date to arraylist
                        dates.add(new Date(col));
                    }
                    
                //if it is literally empty
                    else if (col.equals("")) {}
                    
                //if it is an empty value
                    else if (col.equals("--")) {
//                        System.out.println("check 2");
                        endNum = true;
                        num = "-1";
                    }
                    
                //if it has double quotes
                    else if (!(col.indexOf("\"") == -1)) {
                        
                        //if the num has already started (is at end)
                        if (startOfNum) {
                            num = num + col.substring(0, col.length()-1);
                            endNum = true;
                        } else {
                            num = col.substring(1);
                        }
                        startOfNum = !(startOfNum);
                    }
                    
                //if it has no double quotes
                    else if (col.indexOf("\"") == -1) {
                        
                        //if the num has already started (is in middle)
                        if (startOfNum) {
                            num = num + col;
                        } else {
                            num = col;
                            endNum = true;
                        }
//                        System.out.println("check 3");
                    }
                    
                //if number is done accumulating
                    if (endNum) {
//                        System.out.println("check 3");
                        //add number to wherever you need to
//                        System.out.println(num);
                        switch (counter % 5) {
                            case 0:
                                tempData[0] = Double.parseDouble(num);
                                break;
                            case 1:
                                tempData[1] = Double.parseDouble(num);
                                break;
                            case 2:
                                tempData[2] = Double.parseDouble(num);
                                break;
                            case 3:
                                tempData[3] = Double.parseDouble(num);
                                break;
                            case 4:
                                tempData[4] = Double.parseDouble(num);
                                tempDataArray.add(new DataPoint(dates.get(dateCounter), tempData[0], tempData[1], tempData[2], tempData[3], tempData[4]));
//                                System.out.print(counter);
//                                System.out.println(essentialData[0]);
//                                System.out.println(new DataPoint(dates.get(dateCounter), tempData[0], tempData[1], tempData[2], tempData[3], tempData[4]).getCap());
                                dateCounter++;
                                break;
                        }
                        endNum = !(endNum);
                        counter++;
                    }
                }
                newCompanyData = new CompanyData();
                for (DataPoint newPoint : tempDataArray) {
                    newCompanyData.addDataPoint(newPoint);
                }
                companies.add(new Company(essentialData[0], essentialData[1], essentialData[2], essentialData[3], essentialData[4], newCompanyData));
            }
        }
        for (int i = 0; i < 2000; i++) {
            System.out.println(companies.get(i));
        }
        scanner.close();
    }
}