import java.util.HashMap;

public class YearsReports {
    int year;
    boolean isFilled;
    HashMap<String, Integer> profit;
    HashMap<String, Integer> expense;

    YearsReports(int year) {
        this.year = year;
        isFilled = false;
    }

    public HashMap<String, Integer> fillingProfitReportYear(String[] lines) {
        profit = new HashMap<>();
        for (int i = 3; i < lines.length; i = i + 3) {
            if ("false".equals(lines[i + 2])) {
                profit.put(lines[i], Integer.valueOf(lines[i + 1]));
            }
        }
        return profit;
    }

    public HashMap<String, Integer> fillingExpenseReportYear(String[] lines) {
        expense = new HashMap<>();
        for (int i = 3; i < lines.length; i = i + 3) {
            if ("true".equals(lines[i + 2])) {
                expense.put(lines[i], Integer.valueOf(lines[i + 1]));
            }
        }
        return expense;
    }

    public void getProfitExpYear() {
        System.out.println("01 - Январь : " + (profit.get("01") - expense.get("01")));
        System.out.println("02 - Февраль : " + (profit.get("02") - expense.get("02")));
        System.out.println("03 - Март : " + (profit.get("03") - expense.get("03")));
    }

    public int getProfitYear() {
        int meanProfit = 0;
        for (int volue : profit.values()) {
            meanProfit += volue;
        }
        meanProfit = meanProfit / profit.size();
        return meanProfit;
    }

    public int getExpenseYear() {
        int meanProfit = 0;
        for (int volue : expense.values()) {
            meanProfit += volue;
        }
        meanProfit = meanProfit / expense.size();
        return meanProfit;
    }

    /*public int returnValue(String isExpense, String month) {
        String[] linesReport = ReportUtil.splitReportYears().get(1);
        if ("false".equals(isExpense)) {
            return fillingProfitReportYear(linesReport).get(month);
        } else {
            return fillingExpenseReportYear(linesReport).get(month);
        }
    }*/
}
