import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class AllReportsMonth {
    List<String> arrayList;
    HashMap<Integer, String[]> hashMap;

    public String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public void Report() {
        arrayList = new ArrayList<>();
        arrayList.add(readFileContentsOrNull("resources/m.202101.csv"));
        arrayList.add(readFileContentsOrNull("resources/m.202102.csv"));
        arrayList.add(readFileContentsOrNull("resources/m.202103.csv"));
    }

    public void reader() {
        Report();
        for (String s : arrayList) {
            System.out.println(s);
        }
    }

    public HashMap<Integer, String[]> splitReport() {
        Report();
        hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(i + 1, arrayList.get(i).split("\\n|,"));
        }
        return hashMap;
    }
}
//Не знаю как лучше, оставить один класс на считывание месяцев и годов ,сделав поля класса путь к файлу и соответственно
//конструктор ,либо так как сейчас два класса на это выделить, но будет по сути тот же DRY, если смотреть по ресурсам,
//что будет менее затратно и как лучше сделать?

