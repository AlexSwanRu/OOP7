import java.util.Scanner;

public class ViewCalculator {

    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            int primaryArg = promptInt("Введите действительную часть первого аргумента операции: ");
            Calculable calculator = calculableFactory.create(primaryArg, true);
            while (true) {
                String cmd = prompt("Введите операцию (*, +, /, =) : ");
                if (cmd.equals("*")) {
                    int arg = promptInt("Введите действительную часть второго аргумента операции: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("/")) {
                    int arg = promptInt("Введите действительную часть второго аргумента операции:");
                    calculator.div(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promptInt("Введите действительную часть второго аргумента операции: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Действительная часть результата %d\n", result);
                    break;
                }
            }
            String cmd = prompt("Продолжим вычислять (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}

