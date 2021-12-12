import java.util.HashMap;

public class YearsReports {
    int year;
    int month;
    boolean isFilled;
    HashMap<String, Integer> profit;
    HashMap<String, Integer> expense;

    YearsReports(int year) {
        this.month = month;
        this.year = year;
        isFilled = false;
    }

    public HashMap<String, Integer> fillingExpenseReportYear(String[] lines) {
        expense = new HashMap<>();
        if ("true".equals(lines[2]))
            expense.put(lines[0], Integer.valueOf(lines[1]));
        return expense;
    }

    public HashMap<String, Integer> fillingProfitReportYear(String[] lines) {
        profit = new HashMap<>();
        if ("false".equals(lines[2]))
            profit.put(lines[0], Integer.valueOf(lines[1]));
        return profit;
    }
}
