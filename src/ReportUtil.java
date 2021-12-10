import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportUtil {
    static List<String> reports;
    static HashMap<Integer, String[]> separatedReports;

    private static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static void filledListYears() {
        reports = new ArrayList<>();
        reports.add(readFileContentsOrNull("resources/y.2021.csv"));
    }

    public static void readerLinesReportYear() {
        filledListYears();
        for (String yearReport : reports) {
            System.out.println(yearReport);
        }
    }

    public static HashMap<Integer, String[]> splitReportYears() {
        filledListYears();
        separatedReports = new HashMap<>();
        separatedReports.put(1, reports.get(0).split("\\n|,"));
        return separatedReports;
    }

    public static void filledListMonth() {
        reports = new ArrayList<>();
        reports.add(readFileContentsOrNull("resources/m.202101.csv"));
        reports.add(readFileContentsOrNull("resources/m.202102.csv"));
        reports.add(readFileContentsOrNull("resources/m.202103.csv"));
    }

    public static void readerLinesReportMonth() {
        filledListMonth();
        for (String monthReport : reports) {
            System.out.println(monthReport);
        }
    }

    public static HashMap<Integer, String[]> splitReportMonth() {
        filledListMonth();
        separatedReports = new HashMap<>();
        for (int i = 0; i < reports.size(); i++) {
            separatedReports.put(i + 1, reports.get(i).split("\\n|,"));
        }
        return separatedReports;
    }
}