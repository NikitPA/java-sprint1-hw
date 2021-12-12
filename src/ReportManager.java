import java.util.ArrayList;
import java.util.HashMap;

public class ReportManager {
    ArrayList<MonthReport> monthReports = new ArrayList<>();
    ArrayList<String> rawMonthContent = new ArrayList<>();
    ArrayList<YearsReports> yearReports = new ArrayList<>();
    ArrayList<String> rawYearContent = new ArrayList<>();


    public void outputMontlyReport() {
        saveMonthReports();
        for (String line : rawMonthContent) {
            System.out.println(line);
        }
    }

    public void outputYearsReport() {
        saveYearReports();
        for (String line : rawYearContent) {
            System.out.println(line);
        }
    }

    public void getInfoMonth() {
        for (ArrayList<MonthReport> list : getTotalMonthReport()) {
            System.out.println("Название месяца : " + ReportUtil.getNameOfMonth(list.get(0).month));
            System.out.println("Самый прибыльный товар: " + ReportUtil.getProductMaxProfitPrice(list));
            System.out.println("Cамая большая трата : " + ReportUtil.getProductMaxExpensePrice(list));
        }
    }
    //Здравствуйте , увидел ваши ремондации, спасибо большое за них! В методе getInfoMonth и checkReports вы написали
    // вывод , который идет по каждой строчке месяца, я создал метод который из всех строчек делает листы с месяцами
    //и тоже самое с годами там траты и доходы идут не порядку ,поэтому пришлось создать метод, который сортирует их.
    //И теперь я понял, что значит считать один раз за программу, еще раз спасибо вам за это:))

    public void getInfoYears() {
        System.out.println("Год : " + yearReports.get(0).year + "\nПрибыль по каждому месяцу : ");
        ReportUtil.getMarginYear(yearReports);
        System.out.println("Средний доход : ");
        System.out.println(ReportUtil.getProfitYear(yearReports));
        System.out.println("Средний расход : ");
        System.out.println(ReportUtil.getExpenseYear(yearReports));
    }

    public String checkReports() {
        ArrayList<Boolean> check = new ArrayList<>();
        int i = 1;
        for(ArrayList<MonthReport> list : getTotalMonthReport()) {
            check.add(ReportUtil.countSumProfit(list) == getYearReports("false").get(i - 1).get("0" + i) &&
                    ReportUtil.countSumExpense(list) == getYearReports("true").get(i - 1).get("0" + i));
            i++;
        }
        if (!check.get(0)) {
            return ReportUtil.getNameOfMonth(getTotalMonthReport().get(0).get(0).month);
        } else if (!check.get(1)) {
            return ReportUtil.getNameOfMonth(getTotalMonthReport().get(1).get(1).month);
        } else if (!check.get(2)) {
            return ReportUtil.getNameOfMonth(getTotalMonthReport().get(2).get(2).month);
        } else {
            return "Ошибок в операции не обнаружено, сверка данных прошла успешна";
        }
    }

    public void saveMonthReports() {
        for (int i = 1; i < 4; i++) {
            String fileContents = ReportUtil.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            if (fileContents == null) {
                return;
            }
            rawMonthContent.add(fileContents);
            String[] lines = fileContents.split("\n");
            for (int j = 1; j < lines.length; j++) {
                String line = lines[j];
                String[] lineContents = line.split(",");
                MonthReport monthReport = new MonthReport(2021, i);
                monthReport.fillingExpenseReportMonth(lineContents);
                monthReport.fillingProfitReportMonth(lineContents);
                monthReport.isFilled = true;
                monthReports.add(monthReport);
            }
        }
    }

    public void saveYearReports() {
        for (int i = 1; i < 2; i++) {
            String fileContents = ReportUtil.readFileContentsOrNull("resources/y.202" + i + ".csv");
            if (fileContents == null) {
                return;
            }
            rawYearContent.add(fileContents);
            String[] lines = fileContents.split("\n");
            for (int j = 1; j < lines.length; j++) {
                String line = lines[j];
                String[] lineContents = line.split(",");
                YearsReports yearsReport = new YearsReports(2021);
                yearsReport.fillingExpenseReportYear(lineContents);
                yearsReport.fillingProfitReportYear(lineContents);
                yearsReport.isFilled = true;
                yearReports.add(yearsReport);
            }
        }
    }

    public ArrayList<HashMap<String, Integer>> getYearReports(String isExpense){
        ArrayList<HashMap<String, Integer>> reportYear = new ArrayList<>();
        for (int i = 0; i < yearReports.size(); i++) {
            if ("false".equals(isExpense)) {
                reportYear.add(yearReports.get(i).profit);
            } else {
                reportYear.add(yearReports.get(i).expense);
            }
        }
        for (int i = 0; i < reportYear.size(); i++) {
            if (reportYear.get(i).isEmpty()){
                reportYear.remove(i);
                i--;
            }
        }
        return reportYear;
    }

    public ArrayList<ArrayList<MonthReport>> getTotalMonthReport() {
        ArrayList<MonthReport> listPartMonth;
        ArrayList<ArrayList<MonthReport>> totalMonthReport = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            listPartMonth = new ArrayList<>();
            for (MonthReport monthReport : monthReports) {
                if (monthReport.month == i) {
                    listPartMonth.add(monthReport);
                }
            }
            totalMonthReport.add(listPartMonth);
        }
        return totalMonthReport;
    }
}
