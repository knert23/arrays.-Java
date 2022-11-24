import static java.lang.System.out;

import java.util.Scanner;

public class Task89 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите размерность матрицы 2n х 2n");
        out.println("Введите n:");
        int n = scanner.nextInt();
        if (n < 2) {
            out.println("Введите размерность хотя бы 2");
            while (n < 2) {
                out.println("Повторите попытку, n должно быть > 2");
                n = scanner.nextInt();
            }
        }
        double[][] A = new double[2 * n][2 * n];
        split(A, n);
        printMas(A);
    }

    public static void split(double[][] A, int n) {
        snake(A, n, 0, 0);
        spiral(A, n, 0, n);
        snake(A, n, n, 0);
        spiral(A, n, n, n);
    }

    public static void snake(double[][] A, int n, int  shiftI, int shiftJ) {
        int count = 1;
        for (int k = 0; k < 2 * n - 1; k++) {
            if (k <= n - 1) { // первая половина матрицы (верхний треугольник)
                if (k % 2 == 0) { // k чётное - идём по диагонали снизу вверх
                    for (int i = k, j = n - 1; i >= 0; i--, j--) {
                        A[i + shiftI][j + shiftJ] = count++;
                    }
                } else { // k нечётное - идём по диагонали сверху вниз
                    for (int i = 0, j = n - k - 1; i <= k; i++, j++) {
                        A[i + shiftI][j + shiftJ] = count++;
                    }
                }
            }
            else { //вторая половина матрицы (нижний треугольник)
                if (k % 2 == 0) { // k чётное - идём по диагонали снизу вверх
                    for (int i = n - 1, j = 2 * n - k - 2; i >= k - n + 1; i--, j--) {
                        A[i + shiftI][j + shiftJ] = count++;
                    }
                }
                else { // k нечётное - идём по диагонали сверху вниз
                    for (int i = k - n + 1, j = 0; i <= n - 1; i++, j++) {
                        A[i + shiftI][j + shiftJ] = count++;
                    }
                }
            }
        }
    }

    public static void spiral(double[][] A, int n, int shiftI, int shiftJ) {
        int count = 1;
        double m = Math.ceil(n / 2.0);
        for (int k = 0; k < m; k++) {
            for (int j = k; j <= n - k - 1; j++) {
                A[k + shiftI][j + shiftJ] = count++;
            }
            for (int i = k + 1; i <= n - k - 1; i++) {
                A[i + shiftI][n - k - 1 + shiftJ] = count++;
            }
            for (int j = n - k - 2; j >= k; j--) {
                A[n - k - 1 + shiftI][j + shiftJ] = count++;
            }
            for (int i = n - k - 2; i >= k + 1; i--) {
                A[i + shiftI][k + shiftJ] = count++;
            }
        }

    }

    public static void printMas(double[][] A) {
        out.println("Преобразованная матрица имеет вид:");
        for (double[] doubles : A) {
            for (int j = 0; j < A.length; j++) {
                out.print(doubles[j] + " ");
            }
            out.println();
        }
    }
}
