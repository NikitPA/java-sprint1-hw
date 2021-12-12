import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class ReportUtil {

    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static String getNameOfMonth(int month) {
        String monthName;
        switch (month) {
            case 1:
                monthName = "Январь ";
                break;
            case 2:
                monthName = "Февраль ";
                break;
            case 3:
                monthName = "Март ";
                break;
            default:
                monthName = "Неизвестный месяц";
        }
        return monthName;
    }

    public static String getProductMaxProfitPrice(ArrayList<MonthReport> priceList) {
        int maxPrice = 0;
        String nameProduct = "";
        for (MonthReport monthReport : priceList) {
            for (String s : monthReport.profit.keySet()) {
                int volumPrice = monthReport.profit.get(s);
                if (volumPrice > maxPrice) {
                    maxPrice = volumPrice;
                    nameProduct = s;
                }
            }
            }
        return nameProduct + " - " + maxPrice;
    }

    public static String getProductMaxExpensePrice(ArrayList<MonthReport> priceList) {
        int maxPrice = 0;
        String nameProduct = "";
        for (MonthReport monthReport : priceList) {
            for (String s : monthReport.expense.keySet()) {
                int volumPrice = monthReport.expense.get(s);
                if (volumPrice > maxPrice) {
                    maxPrice = volumPrice;
                    nameProduct = s;
                }
            }
        }
        return nameProduct + " - " + maxPrice;
    }

    public static int countSumProfit(ArrayList<MonthReport> priceList) {
        int sumMonth = 0;
        for (MonthReport monthReport : priceList){
            for (Integer volumPrice : monthReport.profit.values()){
                sumMonth += volumPrice;
            }
        }
        return sumMonth;
    }

    public static int countSumExpense(ArrayList<MonthReport> priceList) {
        int sumMonth = 0;
        for (MonthReport monthReport : priceList){
            for (Integer volumPrice : monthReport.expense.values()){
                sumMonth += volumPrice;
            }
        }
        return sumMonth;
    }

    public static void getMarginYear(ArrayList<YearsReports> yearsReports) {
        System.out.println(getNameOfMonth(1) + (yearsReports.get(0).profit.get("01") - yearsReports.get(1).expense.get("01")));
        System.out.println(getNameOfMonth(2) + (yearsReports.get(2).profit.get("02") - yearsReports.get(3).expense.get("02")));
        System.out.println(getNameOfMonth(3) + (yearsReports.get(5).profit.get("03") - yearsReports.get(4).expense.get("03")));
    }

    public static int getProfitYear(ArrayList<YearsReports> yearsReports) {
        int meanProfit = 0;
        int i = 0;
        for(YearsReports yearsReport : yearsReports){
           for( int value : yearsReport.profit.values()){
               meanProfit += value;
               i++;
           }
        }
        meanProfit = meanProfit / i;
        return meanProfit;
    }

    public static int getExpenseYear(ArrayList<YearsReports> yearsReports) {
        int meanProfit = 0;
        int i = 0;
        for(YearsReports yearsReport : yearsReports){
            for( int value : yearsReport.expense.values()){
                meanProfit += value;
                i++;
            }
        }
        meanProfit = meanProfit / i;
        return meanProfit;
    }
}