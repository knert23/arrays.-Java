import java.util.Scanner;

import static java.lang.System.out;

public class Task81 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Scanner scannerAns = new Scanner(System.in);
            out.println("Если вы желаете перевести целое число, введите true." +
                    "\nЕсли ваш выбор пал на дробное число, введите false.");
            boolean ans = scannerAns.nextBoolean();
            basic(ans);
        }
        catch (Exception e) {
            out.println("Ошибка!");
            main(args);
        }
    }

    public static void basic(boolean ans) {
        out.println("Введите размерность массива N:");
        int N = scanner.nextInt();
        out.println("Введите основание системы счисления base:");
        int base = scanner.nextInt();
        while (base < 2 || base > 9) {
            out.println("Вы ввели не то, 2 <= base <= 9");
            out.println("Введите еще раз");
            base = scanner.nextInt();
        }
        int[] A = new int[N];
        out.println("Введите элементы массива, как компоненты " + base + "-ого числа");
        out.println("Это цифры от " + 0 + " до " + (base - 1) + ":");
        if (ans) {
            int tempInteger = 0;
            masInteger(N, base, A, tempInteger);
        }
        else {
            double tempFloat = 0;
            masFloat(N, base, A, tempFloat);
        }
    }

    public static void masInteger(int N, int base, int[] A, int tempInteger) {
        for (int i = 0; i < N; i++) {
            A[i] = inputInteger(i, N, base);
        }
        out.println();
        out.println("Массив " + base + "-ой формы числа имеет вид:");
        printMas(A);
        for (int i = N - 1, j = 0; i >= 0; i--, j++) {
            tempInteger += A[i] * Math.pow(base, j);
        }
        out.println("");
        out.println("В 10-ой системе счисления число = " + tempInteger);
    }

    public static void printMas(int[] A) {
        out.print("[ ");
        for (int i = 0; i <= A.length-1; i++) {
            out.print(A[i] + " ");
        }
        out.println("]");
    }

    public static int inputInteger(int i, int N, int base) {
        out.println("A[ " + i + " ] = ");
        int A = scanner.nextInt();
        if ((A >= base || A < 0) & i > 0) {
            out.println("Вы ввели число не из интервала от 0 до " + (base - 1));
            while (A >= base || A < 0) {
                out.println("Повторите попытку A[i] от 0 до " + (base - 1));
                out.println("A[ " + i + " ] = ");
                A = scanner.nextInt();
            }
        }
        else if ((A >= base || A < 0) & i == 0) {
            out.println("Вы ввели число не из интервала от 1 до " + (base - 1));
            while (A == 0 || A >= base || A < 0) {
                out.println("Повторите попытку A[i] от 1 до " + (base - 1));
                out.println("A[ " + i + " ] = ");
                A = scanner.nextInt();
            }
        }
        else if (A == 0 & (i == 0 || i == N-1)) {
            while (A == 0 || A >= base || A < 0) {
                out.println("Вы ввели не верно A[ " + i + " ], оно может быть от 1 до " + (base - 1));
                out.println("A[ " + i + " ] = ");
                A = scanner.nextInt();
            }
        }
        return A;
    }

    public static void masFloat(int N, int base, int[] A, double tempFloat) {
        for (int i = 0; i < N; i++) {
            A[i] = inputFloat(i, N, base);
        }
        out.println();
        out.println("Массив " + base + "-ой формы числа имеет вид:");
        printMas(A);
        for (int i = 0, j = -1; i < N; i++, j--) {
            tempFloat += A[i] * Math.pow(base, j);
        }
        out.println("");
        out.printf("В 10-ой системе счисления число = %.6f", tempFloat);
    }

    public static int inputFloat(int i, int N, int base) {
        out.println("A[ " + i + " ] = ");
        int A = scanner.nextInt();
        if ((A >= base || A < 0)) {
            out.println("Вы ввели число не из интервала от 0 до " + (base - 1));
            while (A >= base || A < 0) {
                out.println("Повторите попытку A[i] от 0 до " + (base - 1));
                out.println("A[ " + i + " ] = ");
                A = scanner.nextInt();
            }
        }
        else if (A == 0 & i == N-1) {
            while (A == 0 || A >= base || A < 0) {
                out.println("Вы ввели не верно A[ " + i + " ], оно может быть от 1 до " + (base - 1));
                out.println("A[ " + i + " ] = ");
                A = scanner.nextInt();
            }
        }
        return A;
    }
}