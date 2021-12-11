import java.util.ArrayList;
import java.util.Arrays;

public class ReportManager {
    ArrayList<MonthReport> monthReports = new ArrayList<>();
    ArrayList<String> rawMonthContent = new ArrayList<>();
    ArrayList<MonthReport> yearReports = new ArrayList<>();
    ArrayList<String> rawYearContent = new ArrayList<>();

    public void outputMontlyReport() {
        saveMonthReports();
        for (String line : rawMonthContent) {
            System.out.println(line);
        }
    }

    public void outputYearsReport() {
        saveYearReports();
        for (String line : rawYearContent){
            System.out.println(line);
        }
    }

    public void getInfoMonth() {

        for (MonthReport monthReport : monthReports) {
            System.out.println("Название месяца : " + ReportUtil.getNameOfMonth(monthReport.month));
            System.out.println("Самый прибыльный товар: " + monthReport.getProductMaxPrice(monthReport.profit));
            System.out.println("Cамая большая трата : " + monthReport.getProductMaxPrice(monthReport.expense));
        }
    }

    public String checkReports() {
        ArrayList<Boolean> check = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            if (monthReports.size() < i) {
                return "Отчет № " + i + " не загружен";
            }
            check.add(monthReports.get(i - 1).countSum(monthReports.get(i - 1).profit) == 5
                    &&
                    monthReports.get(i - 1).countSum(monthReports.get(i - 1).expense) == 5);
        }
        if (!check.get(0)) {
            return "01 - Январь";
        } else if (!check.get(1)) {
            return "02 - Февраль";
        } else if (!check.get(2)) {
            return "03 - Март";
        } else {
            return "Ошибок в операции не обнаружено, сверка данных прошла успешна";
        }
    }

    /*public void getInfoYears() {
        System.out.println("Год : " + saveYear().get(0).year + "\nПрибыль по каждому месяцу : ");
        saveYear().get(0).getProfitExpYear();
        System.out.println("Средний доход : ");
        System.out.println(saveYear().get(0).getProfitYear());
        System.out.println("Средний расход : ");
        System.out.println(saveYear().get(0).getExpenseYear());
    }*/

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
                YearsReports yearsReports = new YearsReports(2021);
                yearsReports.fillingExpenseReportYear(lineContents);
                yearsReports.fillingProfitReportYear(lineContents);
                yearsReports.isFilled = true;
            }
        }
    }
}
