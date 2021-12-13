import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReportManager reportManager = new ReportManager();
        boolean isExit = false;
        while (!isExit) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    reportManager.outputMonthlyReport();
                    break;
                case "2":
                    reportManager.outputYearsReport();
                    break;
                case "3":
                    System.out.println(reportManager.checkReports());
                    break;
                case "4":
                    reportManager.getInfoMonth();
                    break;
                case "5":
                    reportManager.getInfoYears();
                    break;
                case "Exit":
                    isExit = true;
                    System.out.println("Выход");
                    break;
                default:
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

