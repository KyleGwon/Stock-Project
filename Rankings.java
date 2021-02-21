package companyPackage;
import java.io.*;
import java.util.ArrayList;
public class Rankings {
    private ArrayList<Company> ranked = new ArrayList<Company>();
    private ArrayList<Company> yields;
    private ArrayList<Company> returns;
    private Date date;
    //default constructor
    public Rankings() {}
    
    public Rankings(Date newDate, ArrayList<Company> companies) {
//        for (Company company : companies) {
//            ranked.add(company);
//        }
        date = newDate;
//        System.out.println(date);
        System.out.println("date");
        rankCompanies(companies);
    }
    
    public static void main(String[] args) {
        System.out.println("main function for Rankings Class");
    }
    
    public void rankCompanies(ArrayList<Company> companies) {
//        System.out.println(companies.get(0));
        RankingHelper helper = new RankingHelper(date);
        returns = helper.rankReturns(companies);
//        System.out.println(companies.get(0));
        yields = helper.rankYields(companies);
//        System.out.println(companies.get(0));
        
//        for (int i = 0; i < 20; i++) {
//            System.out.print(returns.get(i).getCompanyData().getData(date));
//            System.out.println(returns.get(i).getName());
//        }
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//        System.out.println("----------------------");
//        for (int i = 0; i < 1000; i++) {
//            System.out.print(yields.get(i).getCompanyData().getData(date));
//            System.out.println(yields.get(i).getName());
//        }
    }
    
    //getters
    public ArrayList<Company> getRankings(int numOfCompanies) {
        if (numOfCompanies <= ranked.size()) {
            return new ArrayList<Company>(ranked.subList(0, numOfCompanies));
        }
        return ranked;
    }
    
    public ArrayList<Company> getRankings() {
        ArrayList<Integer> combinedRank = new ArrayList<Integer>();
        for (int i = 0; i < returns.size(); i++) {
            for (int j = 0; j < yields.size(); j++) {
//                if (returns.get(i).getName().equals("H&R Block Inc.")) {
//                    System.out.println(i);
//                }
//                if (yields.get(j).getName().equals("H&R Block Inc.")) {
//                    System.out.println(j);
//                    System.out.println("j");
//                }
                if (returns.get(i).getName().equals(yields.get(j).getName())) {
//                    System.out.print(i);
//                    System.out.print(" ");
//                    System.out.print(j);
//                    System.out.println(returns.get(i));
                    
//                    if (yields.get(j).getName().equals("IDT Corporation Class B")) {
//                        System.out.println("hi");
//                    }

                    combinedRank.add(i+j);
//                    System.out.println(yields.get(i).getTicker());
//                    if (returns.get(i).getTicker().equals("POST")) {
//                        System.out.print(returns.get(i).getName());
//                        System.out.println(i+j);
//                    }
                }
            }
        }
//        for (int i = 0; i < combinedRank.size(); i++) {
//            System.out.print(combinedRank.get(i));
//            System.out.println(returns.get(i));
//        }
        sortRanked(combinedRank, returns);
        return ranked;
        
    }
    
    private void sortRanked(ArrayList<Integer> rankInts, ArrayList<Company> companies) {
        ArrayList<Company> copy = new ArrayList<Company>();
//        System.out.println(rankInts.size());
        for (Company company : companies) {
            copy.add(company);
        }
        for (int i = 0; i < rankInts.size(); i++) {
            int pos = i;
            for (int j = i; j < rankInts.size(); j++) {
                if (rankInts.get(pos) > rankInts.get(j)) {
                    pos = j;
                }
            }
            Company minComp = copy.get(pos);
            copy.set(pos, copy.get(i));
            copy.set(i, minComp);
            int min = rankInts.get(pos);
            if (minComp.getName().equals("IDT Corporation Class B")) {
                System.out.println(minComp.getName());
                System.out.println(min);
//                System.out.println(rankInts.get(pos-1));
//                System.out.println(rankInts.get(pos));
//                System.out.println(rankInts.get(pos+1));
            }
            rankInts.set(pos, rankInts.get(i));
            rankInts.set(i, min);
            ranked.add(minComp);
       }
        
//        for (int i = 0; i < rankInts.size(); i++) {
//            int pos = i;
//            for (int j = i; j < rankInts.size(); j++) {
//                if (rankInts.get(pos) > rankInts.get(j)) {
//                    pos = j;
//                }
//            }
//            ranked.add(copy.get(pos));
//            Company min = copy.get(pos);
//            copy.set(pos, copy.get(i));
//            copy.set(i, min);
//            int minInt = rankInts.get(pos);
//            rankInts.set(pos, rankInts.get(i));
//            rankInts.set(i, minInt);
////        System.out.println(rankInts.size());
////        for (int newInt : rankInts) {
////            System.out.println(newInt);
////        }
////            System.out.println(min);
//        }
    }
    
    //toString method
    public String toString() {
        return "rankings lol";
    }
}