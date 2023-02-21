import java.util.Scanner;

public class DepositCalculate {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {

        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return calculationCircle(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {

        return calculationCircle(amount + amount * yearRate * depositPeriod, 2);
    }

    double calculationCircle(double value, int square) {

        double scale = Math.pow(10, square);
        return Math.round(value * scale) / scale;
    }

    void printMenu() {

        int depositPeriod;
        int userChoise;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        int amount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:") ;
        depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        userChoise = scanner.nextInt();

        double result = 0;

            if (userChoise == 1) {

                result = calculateSimplePercent(amount, 0.06, depositPeriod);

            } else if (userChoise == 2) {

                result = calculateComplexPercent(amount, 0.06, depositPeriod);

            }
            System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculate().printMenu();
    }
}
