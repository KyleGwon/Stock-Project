package companyPackage;
import java.io.*;
import java.util.ArrayList;
public class RankingHelper {
    private Date date;
    public RankingHelper() {}

    public RankingHelper(Date newDate) {
        date = newDate;
    }
    
    public ArrayList<Company> rankReturns(ArrayList<Company> companies) {
        for (Company company : companies) {
            company.currentDate(date);
            company.currentCompare(true);
        }
        return companySort(companies);
    }
    
    public ArrayList<Company> rankYields(ArrayList<Company> companies) {
        for (Company company : companies) {
            company.currentDate(date);
            company.currentCompare(false);
        }
        return companySort(companies);
    }

    private ArrayList<Company> companySort(ArrayList<Company> companies) {
        ArrayList<Company> newList = new ArrayList<Company>();
        
        for (int i = 0; i < companies.size(); i++) {
            int pos = i;
            for (int j = i; j < companies.size(); j++) {
                if (companies.get(j).compareTo(companies.get(pos)) > 0) {
                    pos = j;
                }
            }
            Company min = companies.get(pos);
            companies.set(pos, companies.get(i));
            companies.set(i, min);
            if (min.getName().equals("IDT Corporation Class B")) {
                System.out.println(min);
                System.out.println(i);
            }
//            System.out.println(min.getCompanyData().getData(date).getCap());
            if (min.getCompanyData().getData(date).getCap() > 10000) {
                newList.add(min);
            }
        }
        return newList;
    }

}