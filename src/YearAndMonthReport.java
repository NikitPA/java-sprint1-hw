import java.util.HashMap;

public class YearAndMonthReport {
    HashMap<Integer, String[]> hashMapMonthly;
    HashMap<Integer, String[]> hashMapYears;

    YearAndMonthReport(HashMap<Integer, String[]> hashMapMonthly, HashMap<Integer, String[]> hashMapYears) {
        this.hashMapMonthly = hashMapMonthly;
        this.hashMapYears = hashMapYears;
    }

    public String checkWrite() {
        AllReportsYears years = new AllReportsYears();
        AllReportsMonth month = new AllReportsMonth();
        WorkMethodCheck work = new WorkMethodCheck();
        boolean checkOneExp = work.getExpensesMonth(month.splitReport().get(1), "TRUE") ==
                work.getExpensesYear(years.splitReport().get(1), "true").get(1) &&
                work.getExpensesMonth(month.splitReport().get(1), "FALSE") ==
                        work.getExpensesYear(years.splitReport().get(1), "false").get(1);
        boolean checkSecondExp = work.getExpensesMonth(month.splitReport().get(2), "TRUE") ==
                work.getExpensesYear(years.splitReport().get(1), "true").get(2) &&
                work.getExpensesMonth(month.splitReport().get(2), "FALSE") ==
                        work.getExpensesYear(years.splitReport().get(1), "false").get(2);
        boolean checkTrirdExp = work.getExpensesMonth(month.splitReport().get(3), "TRUE") ==
                work.getExpensesYear(years.splitReport().get(1), "true").get(3) &&
                work.getExpensesMonth(month.splitReport().get(3), "FALSE") ==
                        work.getExpensesYear(years.splitReport().get(1), "false").get(3);
        if (!checkOneExp) {
            return "01 - Январь";
        } else if (!checkSecondExp) {
            return "02 - Февраль";
        } else if (!checkTrirdExp) {
            return "03 - Март";
        } else {
            return "Ошибок в операции не обнаружено, сверка данных прошла успешна";
        }
    }
}
