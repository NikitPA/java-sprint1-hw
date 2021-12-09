import java.util.HashMap;

public class MaxTurnoverYears {

    public void getProfitExpYear(String[] lines) {
        HashMap<Integer, Integer> hashMapProfit = new HashMap<>();
        HashMap<Integer, Integer> hashMapExp = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if ("false".equals(lines[i]))
                hashMapProfit.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
            if ("true".equals(lines[i]))
                hashMapExp.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        System.out.println("01 - Январь : " + (hashMapProfit.get(1) - hashMapExp.get(1)));
        System.out.println("02 - Февраль : " + (hashMapProfit.get(2) - hashMapExp.get(2)));
        System.out.println("03 - Март : " + (hashMapProfit.get(3) - hashMapExp.get(3)));
    }

    public int getProfitAndExpYear(String[] lines, String isExpense) {
        HashMap<Integer, Integer> hashMapProfit = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (isExpense.equals(lines[i]))
                hashMapProfit.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        int meanProfit = 0;
        for (int volue : hashMapProfit.values()) {
            meanProfit += volue;
        }
        meanProfit = meanProfit / hashMapProfit.size();
        return meanProfit;
    }
}
