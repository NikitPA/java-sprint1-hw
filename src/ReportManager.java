import java.util.ArrayList;

public class ReportManager {

    public void outputMontlyReport() {
        ReportUtil.readerLinesReportMonth();
    }

    public void outputYearsReport() {
        ReportUtil.readerLinesReportYear();
    }

    public String checkWrite() {
        ArrayList<Boolean> check = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            check.add(saveMonth().get(0).returnValue("false", i) ==
                    saveYear().get(0).returnValue("false", "0" + i) && saveMonth().get(0).returnValue("true", i) ==
                    saveYear().get(0).returnValue("true", "0" + i));
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

    public void getInfoMonth() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Название месяца : " + saveMonth().get(i).month);
            System.out.println("Самый прибыльный товар: " + saveMonth().get(i).returnString("false", i + 1));
            System.out.println("Cамая большая трата : " + saveMonth().get(i).returnString("true", i + 1));
        }
    }

    public void getInfoYears() {
        System.out.println("Год : " + saveYear().get(0).year + "\nПрибыль по каждому месяцу : ");
        saveYear().get(0).getProfitExpYear();
        System.out.println("Средний доход : ");
        System.out.println(saveYear().get(0).getProfitYear());
        System.out.println("Средний расход : ");
        System.out.println(saveYear().get(0).getExpenseYear());
    }

    public ArrayList<MonthReport> saveMonth() {
        ArrayList<MonthReport> monthRep = new ArrayList<>();
        monthRep.add(new MonthReport("2021", "Январь", false));
        monthRep.add(new MonthReport("2021", "Февраль", false));
        monthRep.add(new MonthReport("2021", "Март", false));
        return monthRep;
    }

    public ArrayList<YearsReports> saveYear() {
        ArrayList<YearsReports> yearRep = new ArrayList<>();
        yearRep.add(new YearsReports("2021", false));
        return yearRep;
    }
}
