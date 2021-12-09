public class MaxTurnoverMonth {

    public String getMaxExpAndProfMonth(String[] lines, String isExpense) {
        int sumMonth = 0;
        String nameProduct = "";
        for (int i = 0; i < lines.length; i++) {
            if (isExpense.equals(lines[i])) {
                int volumePrice = Integer.parseInt(lines[i + 2]) * Integer.parseInt(lines[i + 1]);
                if (volumePrice > sumMonth) {
                    sumMonth = volumePrice;
                    nameProduct = lines[i - 1];
                }
            }
        }
        return nameProduct + " - " + sumMonth;
    }
}
