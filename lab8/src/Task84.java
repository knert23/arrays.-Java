import static java.lang.System.out;

import java.util.Scanner;

public class Task84 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите размерность массива:");
        int n = scanner.nextInt();
        if ((n == 0) | (n == 1))
            throw new IllegalArgumentException("Пожалуйста, введите размерность, хотя бы равную 2");
        double[] A = new double[n];
        double[] B = new double[n];
        out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            out.println("[A" + i + "]=");
            A[i] = scanner.nextDouble();
            B[i] =  A[i];
        }
        shakerSorting(A, B);
    }

    public static void shakerSorting(double[] A, double[] B) {
        int left = 0;
        int right = A.length - 1;
        int k = 1;
        int countMas1 = 0;
        while ((left < right) & (k > 0)) {
            k = 0;
            for (int i = left; i < right; i++) {
                if (A[i] >= A[i+1]) {
                    double C = A[i]; //чтобы они поменялись местами, а не оставались такими же, какие и были
                    A[i] = A[i+1];
                    A[i+1] = C;
                    k = 1;
                }
            }
            right--;
            for (int j = right; j > left; j--) {
                if (A[j-1] >= A[j]) {
                    double C = A[j]; //чтобы они поменялись местами, а не оставались такими же, какие и были
                    A[j] = A[j-1];
                    A[j-1] = C;
                    k = 1;
                }
            }
            left++;
            countMas1++;
            for (double v : A) {
                out.print("\t" + v);
            }
            out.println();
        }
        out.printf("Сортирование шейкер-сортировкой заняло итераций: %d", countMas1);
        bubbleSorting(B);
    }

    public static void bubbleSorting(double[] B) {
        out.println();
        int countMas2 = 0;
        for (int i = B.length - 1; i >= 1; i--) {
            if (B[i - 1] > B[i]) {
                 double temp= B[i - 1]; //чтобы они поменялись местами, а не оставались такими же, какие и были
                B[i - 1] = B[i];
                B[i] = temp;
                i = B.length;
                countMas2++;
                for (int j = 0; j < B.length; j++) {
                    if (j == 0)
                        out.println();
                    out.print("\t" + B[j]);
                }
            }
        }
        out.println();
        out.printf("Сортирование пузырьком заняло итераций: %d", countMas2);
    }
}

