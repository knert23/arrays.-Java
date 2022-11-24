import static java.lang.System.out;

import java.util.Scanner;

public class Task86 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите размерность матрицы n х m" +
                "\nn - число строк, m - число стлобцов");
        out.println("Введите n:");
        int n = scanner.nextInt();
        if (n < 2) {
            out.println("Введите размер строки хотя бы 2");
            while(n < 2) {
                out.println("Повторите попытку, n должно быть > 2");
                n = scanner.nextInt();
            }
        }
        out.println("Введите m:");
        int m = scanner.nextInt();
        if (m < 2) {
            out.println("Введите размер столбца хотя бы 2");
            while(m < 2) {
                out.println("Повторите попытку, m должно быть > 2");
                m = scanner.nextInt();
            }
        }
        double[][] A = new double[n][m];
        out.println("Введите элементы матрицы:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = scanner.nextDouble();
            }
        }
        int check = 0; // для вывода
        printMas(A, check, n, m);
        replacement(A, n, m, check);
    }

    public static void replacement(double[][] A, int n, int m, int check) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (A[i][j] < 0) { // проверяем есть ли отрицаетльный элемент, есть - увеличиваем count
                    count++;
                }
            }
            if (count >= 1) { // count >= 1 - вычитываем поэлементно последнюю строку
                for (int h = 0; h < m; h++) {
                    A[n-1][h]--;
                }
            }
            else { // count == 0 - четные по номеру столбца элементы меняем на противоположные по знаку
                for (int k = 0; k < n; k++ ) {
                    if (k % 2 == 0) {
                        A[i][k] = A[i][k] * (-1);
                    }
                }
            }
        }
        check++;
        printMas(A, check, n, m);
    }

    public static void printMas(double[][] A, int check, int n, int m) {
        if (check == 0)
            out.println("Исходная матрица имеет вид:");
        else
            out.println("Преобразованаая матрица имеет вид:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.printf("\t%.2f", A[i][j]);
            }
            out.println();
        }
    }
}
