import java.util.HashMap;

public class WorkMethodCheck {

    public HashMap<Integer, Integer> getExpensesYear(String[] lines, String isExpense) {
        HashMap<Integer, Integer> hashMapExpenses = new HashMap<>();
        for (int i = 0; i < lines.length; i++) {
            if (isExpense.equals(lines[i]))
                hashMapExpenses.put(Integer.parseInt(lines[i - 2]), Integer.parseInt(lines[i - 1]));
        }
        return hashMapExpenses;
    }

    public int getExpensesMonth(String[] lines, String isExpense) {
        int sumMonth = 0;
        for (int i = 0; i < lines.length; i++) {
            if (isExpense.equals(lines[i])) {
                int volumePrice = Integer.parseInt(lines[i + 2]) * Integer.parseInt(lines[i + 1]);
                sumMonth += volumePrice;
            }
        }
        return sumMonth;
    }
}
