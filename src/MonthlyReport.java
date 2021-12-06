import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MonthlyReport {

    public void getInfoMonth() {
        String monthOneReport = readFileContentsOrNull("resources/m.202101.csv");
        String monthSecondReport = readFileContentsOrNull("resources/m.202102.csv");
        String monthTrirdReport = readFileContentsOrNull("resources/m.202103.csv");
        String yearReport = readFileContentsOrNull("resources/y.2021.csv");
        String[] linesOne = monthOneReport.split("\\n|,");
        String[] linesSecond = monthSecondReport.split("\\n|,");
        String[] linesThird = monthTrirdReport.split("\\n|,");
        String[] linesYear = yearReport.split("\\n|,");
        System.out.println("Название месяца : Январь.\nСамый прибыльный товар: " + getMaxProfitMonth(linesOne) +
                ".\nСамая большая трата : " + getMaxExpMonth(linesOne));
        System.out.println("\nНазвание месяца : Февраль.\nСамый прибыльный товар: " + getMaxProfitMonth(linesSecond) +
                ".\nСамая большая трата : " + getMaxExpMonth(linesSecond));
        System.out.println("\nНазвание месяца : Март.\nСамый прибыльный товар: " + getMaxProfitMonth(linesThird) +
                ".\nСамая большая трата : " + getMaxExpMonth(linesThird));
    }

    public String getMaxProfitMonth(String[] lines) {
        int sumMonth = 0;
        String nameProduct = "";
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("FALSE")) {
                int volumePrice = Integer.parseInt(lines[i + 2]) * Integer.parseInt(lines[i + 1]);
                if (volumePrice > sumMonth) {
                    sumMonth = volumePrice;
                    nameProduct = lines[i - 1];
                }
            }
        }
        return nameProduct + " - " + sumMonth;
    }

    public String getMaxExpMonth(String[] lines) {
        int sumMonth = 0;
        String nameProduct = "";
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].equals("TRUE")) {
                int volumePrice = Integer.parseInt(lines[i + 2]) * Integer.parseInt(lines[i + 1]);
                if (volumePrice > sumMonth) {
                    sumMonth = volumePrice;
                    nameProduct = lines[i - 1];
                }
            }
        }
        return nameProduct + " - " + sumMonth;
    }

    public void readAllFileMonth() {
        System.out.println(readFileContentsOrNull("resources/m.202101.csv"));
        System.out.println(readFileContentsOrNull("resources/m.202102.csv"));
        System.out.println(readFileContentsOrNull("resources/m.202103.csv"));

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
