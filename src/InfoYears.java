import java.util.HashMap;

public class InfoYears {
    HashMap<Integer, String[]> hashMap;

    InfoYears(HashMap<Integer, String[]> hashMap) {

        this.hashMap = hashMap;
    }

    public void getInfoYear() {
        AllReportsYears years = new AllReportsYears();
        MaxTurnoverYears turnoverYears = new MaxTurnoverYears();
        System.out.println("Год : 2021.\n" + "Прибыль по каждому месяцу : ");
        turnoverYears.getProfitExpYear(years.splitReport().get(1));
        System.out.println("Средний доход : ");
        System.out.println(turnoverYears.getProfitAndExpYear(years.splitReport().get(1), "false"));
        System.out.println("Средний расход : ");
        System.out.println(turnoverYears.getProfitAndExpYear(years.splitReport().get(1), "true"));
    }
}
