import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearlyReport {

    public void getInfoYear() {
        String yearReport = readFileContentsOrNull("resources/y.2021.csv");
        String[] linesYear = yearReport.split("\\n|,");
        System.out.println("Год : 2021.\n" + "Прибыль по каждому месяцу : ");
        getProfitExpYear(linesYear);
        System.out.println("Средний доход : ");
        System.out.println(getProfitYear(linesYear));
        System.out.println("Средний расход : ");
        System.out.println(getExpensesYear(linesYear));
    }

    public void getProfitExpYear(String[] lines) {
        HashMap<Integer, Integer> hashMapProfit = new HashMap<>();
        HashMap<Integer, Integer> hashMapExp = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("false"))
                hashMapProfit.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
            if (lines[i].equals("true"))
                hashMapExp.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        System.out.println("01 - Январь : " + (hashMapProfit.get(1) - hashMapExp.get(1)));
        System.out.println("02 - Февраль : " + (hashMapProfit.get(2) - hashMapExp.get(2)));
        System.out.println("03 - Март : " + (hashMapProfit.get(3) - hashMapExp.get(3)));
    }

    public int getProfitYear(String[] lines) {
        HashMap<Integer, Integer> hashMapProfit = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("false"))
                hashMapProfit.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        int meanProfit = 0;
        for (int volue : hashMapProfit.values()) {
            meanProfit += volue;
        }
        meanProfit = meanProfit / hashMapProfit.size();
        return meanProfit;
    }

    public int getExpensesYear(String[] lines) {
        HashMap<Integer, Integer> hashMapExpenses = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("true"))
                hashMapExpenses.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        int meanExp = 0;
        for (int volue : hashMapExpenses.values()) {
            meanExp += volue;
        }
        meanExp = meanExp / hashMapExpenses.size();
        return meanExp;
    }

    public void readAllFileMonth() {
        System.out.println(readFileContentsOrNull("resources/y.2021.csv"));
    }

    private String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
