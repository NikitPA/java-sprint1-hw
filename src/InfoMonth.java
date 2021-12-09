import java.util.HashMap;

public class InfoMonth {
    HashMap<Integer, String[]> hashMap;

    InfoMonth(HashMap<Integer, String[]> hashMap) {
        this.hashMap = hashMap;
    }

    public void getInfoMonth() {
        AllReportsMonth allReportsMonth = new AllReportsMonth();
        MaxTurnoverMonth maxTurnoverMonth = new MaxTurnoverMonth();
        System.out.println("Название месяца : Январь.\nСамый прибыльный товар: " + maxTurnoverMonth.
                getMaxExpAndProfMonth(allReportsMonth.splitReport().get(1), "FALSE") + ".\nСамая большая " +
                "трата : " + maxTurnoverMonth.getMaxExpAndProfMonth(allReportsMonth.splitReport().get(1), "TRUE"));
        System.out.println("\nНазвание месяца : Февраль.\nСамый прибыльный товар: " + maxTurnoverMonth.
                getMaxExpAndProfMonth(allReportsMonth.splitReport().get(2), "FALSE") +
                ".\nСамая большая трата : " + maxTurnoverMonth.getMaxExpAndProfMonth
                (allReportsMonth.splitReport().get(2), "TRUE"));
        System.out.println("\nНазвание месяца : Март.\nСамый прибыльный товар: " + maxTurnoverMonth.
                getMaxExpAndProfMonth(allReportsMonth.splitReport().get(3), "FALSE") +
                ".\nСамая большая трата : " + maxTurnoverMonth.getMaxExpAndProfMonth
                (allReportsMonth.splitReport().get(3), "TRUE"));
    }
}
