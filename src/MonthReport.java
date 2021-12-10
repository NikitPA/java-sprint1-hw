import java.util.HashMap;

public class MonthReport {
    String year;
    String month;
    boolean isFilled;
    HashMap<String, Integer> profit;
    HashMap<String, Integer> expense;

    MonthReport(String year, String month, boolean isFilled) {
        this.year = year;
        this.month = month;
        isFilled = false;
    }

    public HashMap<String, Integer> fillingProfitReportMonth(String[] lines) {
        profit = new HashMap<>();
        for (int i = 4; i < lines.length; i = i + 4) {
            if ("FALSE".equals(lines[i + 1]))
                profit.put(lines[i], (Integer.valueOf(lines[i + 2]) * Integer.valueOf(lines[i + 3])));
        }
        isFilled = true;
        return profit;
    }

    public HashMap<String, Integer> fillingExpenseReportMonth(String[] lines) {
        expense = new HashMap<>();
        for (int i = 4; i < lines.length; i = i + 4) {
            if ("TRUE".equals(lines[i + 1]))
                expense.put(lines[i], (Integer.valueOf(lines[i + 2]) * Integer.valueOf(lines[i + 3])));
        }
        isFilled = true;
        return expense;
    }

    public String getMaxProfAndExpMonth(HashMap<String, Integer> profExp) {
        int sumMonth = 0;
        String nameProduct = "";
        for (String product : profExp.keySet()) {
            int volumePrice = profExp.get(product);
            if (volumePrice > sumMonth) {
                sumMonth = volumePrice;
                nameProduct = product;
            }
        }
        return nameProduct + " - " + sumMonth;
    }

    public String returnString(String isExpense, int month) {
        String[] linesReport = ReportUtil.splitReportMonth().get(month);
        if ("false".equals(isExpense)) {
            return getMaxProfAndExpMonth(fillingProfitReportMonth(linesReport));
        } else {
            return getMaxProfAndExpMonth(fillingExpenseReportMonth(linesReport));
        }
    }

    public int getExpAndProfMonth(HashMap<String, Integer> profExp) {
        int sumMonth = 0;
        for (Integer volumePrice : profExp.values()) {
            sumMonth += volumePrice;
        }
        return sumMonth;
    }

    public int returnValue(String isExpense, int month) {
        String[] linesReport = ReportUtil.splitReportMonth().get(month);
        if ("false".equals(isExpense)) {
            return getExpAndProfMonth(fillingProfitReportMonth(linesReport));
        } else {
            return getExpAndProfMonth(fillingExpenseReportMonth(linesReport));
        }
    }
}
