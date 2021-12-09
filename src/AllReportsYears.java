import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AllReportsYears {
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
        arrayList.add(readFileContentsOrNull("resources/y.2021.csv"));
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
