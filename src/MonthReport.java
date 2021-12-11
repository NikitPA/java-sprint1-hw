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

    public String getProductMaxPrice(HashMap<String, Integer> pricelist) {
        int maxPrice = 0;
        String nameProduct = "";
        for (String product : pricelist.keySet()) {
            int volumePrice = pricelist.get(product);
            if (volumePrice > maxPrice) {
                maxPrice = volumePrice;
                nameProduct = product;
            }
        }
        return nameProduct + " - " + maxPrice;
    }

    public int countSum(HashMap<String, Integer> pricelist) {
        int sumMonth = 0;
        for (Integer volumePrice : pricelist.values()) {
            sumMonth += volumePrice;
        }
        return sumMonth;
    }
}