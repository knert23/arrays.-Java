import java.util.Scanner;

import static java.lang.System.out;

public class Task812 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        out.println("Введите размерность матрицы n x n");
        out.println("Введите размерность строки n:");
        int n = scanner.nextInt();
        double[][] A = new double[n][n];
        out.println("Введите исходную матрицу");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }
        out.println("Введите обратную матрицу:");
        double[][] inverseA = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverseA[i][j] = scanner.nextDouble();
            }
        }
        check(A, inverseA, n);
    }

    public static void check(double[][] A, double[][] inverseA, int n) {
        double[][] E = new double[n][n];
        double[][] C = new double[n][n];
        int countE = 1;

        for(int k = 0; k < n; k++) { // единичная матрица
            E[k][k] = countE;
        }

        for (int i = 0; i < n; i++) { // матрица, которая получается после перемножения исходной и обратной
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * inverseA[k][j];
                }
            }
        }

        int countCE = 0;
        for (int i = 0; i < n; i++) { // сравнение с единичной матрицей
            for (int j = 0; j < n; j++) {
                if (C[i][j] == E[i][j]) {
                    countCE++;
                }
            }
        }

        if (countCE == n * n) {
            out.println("Исходная матрица и обратная к ней матрица введены верно");
        }
        else {
            out.println("Вы ввели неверно обратную матрицу");
            printMas(C);
        }
    }

    public static void printMas(double[][] C) {
        out.println("Матрица, полученная путем перемножения исходной и обратной матрицы, имеет вид:");
        for (double[] doubles : C) {
            for (int j = 0; j < C.length; j++) {
                out.print(doubles[j] + " ");
            }
            out.println();
        }
    }
}
