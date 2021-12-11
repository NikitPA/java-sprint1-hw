import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ReportUtil {

    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public static String getNameOfMonth(int month) {
        String monthName;
        switch (month) {
            case 1:
                monthName = "Январь";
                break;
            case 2:
                monthName = "Февраль";//подумать нужно ли дописывать все месяца...
            case 3:
                monthName = "Март";
            default:
                monthName = "Неизвестный месяц";
        }
        return monthName;
    }
}