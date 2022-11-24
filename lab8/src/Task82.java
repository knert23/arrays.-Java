import static java.lang.System.out;

import java.util.Scanner;

public class Task82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.println("Введите количество элементов массива:");
        int n = scanner.nextInt();
        int[] A = new int [n];
        out.println("Введите элементы массива - целые числа:");
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
        }
        checkNumber(A);
    }
    public static void checkNumber(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if ((i % 2 == 0) & (A[i] % 2 == 0)) {
                count++;
            }
        }
        if(count == 0) {
            out.println("Четных элементов, которые стоят на четных по номеру ячейках, не найдено");
        }
        else {
            out.println("Количество четных элементов, которые стоят на четных по номерам ячейках, равно " + count);
        }
    }
}
