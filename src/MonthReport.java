import java.util.HashMap;

public class MonthReport {
    int year;
    int month;
    boolean isFilled;
    HashMap<String, Integer> profit;
    HashMap<String, Integer> expense;

    MonthReport(int year, int month) {
        this.year = year;
        this.month = month;
        this.isFilled = false;
    }

    public HashMap<String, Integer> fillingProfitReportMonth(String[] lines) {
        profit = new HashMap<>();
        if ("FALSE".equals(lines[1]))
            profit.put(lines[0], (Integer.valueOf(lines[2]) * Integer.valueOf(lines[3])));
        return profit;
    }

    public HashMap<String, Integer> fillingExpenseReportMonth(String[] lines) {
        expense = new HashMap<>();
        if ("TRUE".equals(lines[1]))
            expense.put(lines[0], (Integer.valueOf(lines[2]) * Integer.valueOf(lines[3])));
        return expense;
    }
}