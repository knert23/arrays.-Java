import static java.lang.System.out;

import java.util.Scanner;

public class Task87 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите размерность матрицы n х n");
        out.println("Введите n:");
        int n = scanner.nextInt();
        if (n < 2) {
            out.println("Введите размерность хотя бы 2");
            while (n < 2) {
                out.println("Повторите попытку, n должно быть > 2");
                n = scanner.nextInt();
            }
        }
        double[][] A = new double[n][n];
        permutation(A, n);
    }

    public static void permutation(double[][] A, double n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) { // строчка чётная - идём по диагонали сверху вниз
                for (int h = 0, j = i; h <= i; h++, j--) {
                    A[h][j] = count++;
                }
            }
            else { // строчка нечётная - идём по диагонали снизу вверх
                for (int h = i, j = 0; h >= 0; h--, j++) {
                    A[h][j] = count++;
                }
            }
        }
        printMas(A);
    }

    public static void printMas(double[][] A) {
        out.println("Преобразованная матриц имеет вид:");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                out.print(A[i][j] + " ");
            }
            out.println();
        }
    }
}
