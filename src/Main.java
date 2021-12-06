import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        YearAndMonthReport yearandMonthReport = new YearAndMonthReport();
        while (true) {
            printMenu();
            String command = scanner.nextLine();
            if (command.equals("1")) {
                monthlyReport.readAllFileMonth();
            } else if (command.equals("2")) {
                yearlyReport.readAllFileMonth();
            } else if (command.equals("3")) {
                System.out.println(yearandMonthReport.checkWrite());
            } else if (command.equals("4")) {
                monthlyReport.getInfoMonth();
            } else if (command.equals("5")) {
                yearlyReport.getInfoYear();
            } else if (command.equals("Exit")) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Такой команды нет ");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчеты ");
        System.out.println("2 - Считать годовой отчет ");
        System.out.println("3 - Сверить отчеты ");
        System.out.println("4 - Вывести информацию о всех месячных отчетах ");
        System.out.println("5 - Вывести информацию о годовом отчете ");
        System.out.println("Exit - Выход из программы ");
    }
}

