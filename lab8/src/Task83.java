import java.util.Scanner;

import static java.lang.System.out;

import static java.lang.Math.*;

public class Task83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите размерность массива:");
        int n = scanner.nextInt();
        if ((n % 2 != 0) | (n < 8) | (n == 0))
            throw new IllegalArgumentException("Вы должны задать для массива четное количество точек, >= 8");
        out.println("Введите координаты x1, y1, х2, y2, x3, y3, и т.д");
        double[] A = new double[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextDouble();
        }
        coordinates(A);
    }

    public static void coordinates(double[] A) {
        double[] B = new double[8]; //новый массив,чтобы записать туда первые 8 элементов
        for (int i = 0; i < A.length - 6; i += 2) {
            B[0] = A[i];
            B[1] = A[i + 1];
            for (int j = i + 2; j < A.length - 4; j += 2) {
                B[2] = A[j];
                B[3] = A[j + 1];
                for (int k = j + 2; k < A.length - 2; k += 2) {
                    B[4] = A[k];
                    B[5] = A[k + 1];
                    for (int l = k + 2; l < A.length; l += 2) {
                        B[6] = A[l];
                        B[7] = A[l + 1];
                        if (isSquare(B)) {
                            for (int coord = 0; coord < B.length; coord++)
                                out.print(coord + " ");
                            out.println("");
                            out.println("Номера точек, которые могут являться вершинами квадрата, представлены выше");
                        }
                        else
                            out.println("Точек не найдено");
                    }
                }
            }
        }
    }
    public static boolean isSquare(double[] B) {
        double AB = sqrt((pow((B[0] - B[2]), 2)) + pow((B[1] - B[3]), 2));
        double CD = sqrt((pow((B[4] - B[6]), 2)) + pow((B[5] - B[7]), 2));
        double BC = sqrt((pow((B[2] - B[4]), 2)) + pow((B[3] - B[5]), 2));
        double AD = sqrt((pow((B[0] - B[6]), 2)) + pow((B[1] - B[7]), 2));
        return ((AB == CD) & (AB == BC) & (AB == AD));
    }
}
