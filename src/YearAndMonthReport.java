import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class YearAndMonthReport {

    public String checkWrite() {
        String monthOneReport = readFileContentsOrNull("resources/m.202101.csv");
        String monthSecondReport = readFileContentsOrNull("resources/m.202102.csv");
        String monthTrirdReport = readFileContentsOrNull("resources/m.202103.csv");
        String yearReport = readFileContentsOrNull("resources/y.2021.csv");
        String[] linesOne = monthOneReport.split("\\n|,");
        String[] linesSecond = monthSecondReport.split("\\n|,");
        String[] linesThird = monthTrirdReport.split("\\n|,");
        String[] linesYear = yearReport.split("\\n|,");
        boolean checkOneExp = getExpensesMonth(linesOne) == getExpensesYear(linesYear).get(1) &&
                getProfitMonth(linesOne) == getProfitYear(linesYear).get(1);
        boolean checkSecondExp = getExpensesMonth(linesSecond) == getExpensesYear(linesYear).get(2) &&
                getProfitMonth(linesSecond) == getProfitYear(linesYear).get(2);
        boolean checkTrirdExp = getExpensesMonth(linesThird) == getExpensesYear(linesYear).get(3) &&
                getProfitMonth(linesThird) == getProfitYear(linesYear).get(3);
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

    public HashMap<Integer, Integer> getExpensesYear(String[] lines) {
        HashMap<Integer, Integer> hashMapExpenses = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("true"))
                hashMapExpenses.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        return hashMapExpenses;
    }

    public HashMap<Integer, Integer> getProfitYear(String[] lines) {
        HashMap<Integer, Integer> hashMapProfit = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("false"))
                hashMapProfit.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        return hashMapProfit;
    }

    public int getExpensesMonth(String[] lines) {
        int sumMonth = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("TRUE")) {
                int volumePrice = Integer.parseInt(lines[i + 2]) * Integer.parseInt(lines[i + 1]);
                sumMonth += volumePrice;
            }
        }
        return sumMonth;
    }

    public int getProfitMonth(String[] lines) {
        int sumMonth = 0;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("FALSE")) {
                int volumePrice = Integer.parseInt(lines[i + 2]) * Integer.parseInt(lines[i + 1]);
                sumMonth += volumePrice;
            }
        }
        return sumMonth;
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
