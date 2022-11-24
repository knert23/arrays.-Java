import java.util.Scanner;

import static java.lang.System.out;

public class Task85 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите размер (m x n) двумерного массива" );
        out.println("Введите m:");
        int m = scanner.nextInt();
        out.println("Введите n:");
        int n = scanner.nextInt();
        out.println("Введите элементы матрицы:");
        double[][] A = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }
        int count = 0;
        printMas(A, m, n, count);
        minElement(A, n, args, m, count);
    }

    public static void minElement(double[][] A, int n, String[] args, int m, int count) {
        double minA = A[0][0];
        int minJ = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (minA >= A[i][j]) {
                    minA = A[i][j];
                    minJ = j; //столбец с наименьшим элементом
                }
            }
        }
        check(A, n, minJ, args, m, count);
    }

    public static void check(double[][] A,int n, int minJ, String[] args, int m, int count) {
        if (minJ == n - 1) {
            out.println("Ошибка!" +
                    "\nНаименьший элемент массива находится в последнем столбце");
            main(args);
        }
        else
            replacement(A, minJ, n, m, count);
    }

    public static void replacement(double[][] A, int minJ, int n, int m, int count) {
        for(int i = 0; i < A.length; i++) {
            double B = A[i][minJ]; //чтобы они поменялись местами, а не оставались такими же, какие и были
            A[i][minJ] = A[i][n-1];
            A[i][n-1] = B;
        }
        count++;
        printMas(A, m, n, count);
    }

    public static void printMas(double[][] A, int m, int n, int count) {
        if (count == 0)
            out.println("Исходная матрица имеет вид:");
        else
            out.println("Матрица после перестановки имеет вид:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out.print(A[i][j] + "\t");
            }
            out.println();
        }
    }
}
