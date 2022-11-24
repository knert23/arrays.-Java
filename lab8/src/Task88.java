import static java.lang.System.out;

import java.util.Scanner;

public class Task88 {
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
        int m = (int) Math.ceil(n / 2.0);
        split(A, m, n);
    }

    public static void split(double[][] A, int m, int n) {
        block(A, m, 0, 0);
        block(A, m, 0, m);
        block(A, m,  m, 0);
        block(A, m, m, m);
        printMas(A);
    }

    public static void block(double[][] A, int m, int shiftI, int shiftJ) {
        int count = 1;
        for (int k = 0; k <= m; k++) {
            for (int j = k; j < m - k; j++) {
                A[m - 1 - k + shiftI][j + shiftJ] = count++;
            }
            for (int i = m - 2 - k; i >= k; i--) {
                A[i + shiftI][m - 1 - k + shiftJ] = count++;
            }
            for (int i = m - 2 - k; i >= k; i--) {
                A[i + shiftI][k + shiftJ] = count++;
            }
            for (int j = k + 1; j <= m - 2 - k; j++) {
                A[k + shiftI][j + shiftJ] = count++;
            }
        }
    }

    public static void printMas(double[][] A) {
        out.println("Преобразованная матрица имеет вид:");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                out.print(A[i][j] + " ");
            }
            out.println();
        }
    }
}
