package HW_2;

import com.sun.org.apache.xpath.internal.objects.XBoolean;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//1. Задать целочисленный массив, состоящий из элементов 0 и 1. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Задание 1\n" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) arr[i] = 0;
            else arr[i] = 1;
        }
        System.out.println(Arrays.toString(arr));

//2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] arr2 = new int[8];
        int j = 0;
        for (int i = 0; i < arr2.length; i++, j = j + 3) {
            arr2[i] = j;
        }
        System.out.println("\nЗадание №2\n" + Arrays.toString(arr2));

//3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\nЗадание №3\n" + Arrays.toString(arr3) + "\nЧисла меньше 6 умножить на 2");
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] = arr3[i] * 2;
        }
        System.out.println(Arrays.toString(arr3));

//4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        System.out.println("\nЗадание №4");
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int l = 0; l < arr4.length; l++) {
                if ((i == l) || (i == arr4.length - 1 - l)) {
                    arr4[i][l] = 1;
                }
            }
        }
        for (int i = 0; i < arr4.length; i++) {
            for (int l = 0; l < arr4.length; l++) {
                System.out.print(arr4[i][l] + " ");
            }
            System.out.println();
        }
//5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("\nЗадание №5*");
        int[] arr5 = {0, 1, 5, 6, 2, 8, 0, 12, 555, 99, 15};
        int min = arr5[0], max = arr5[0];
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > max) {
                max = arr5[i];
            }
            if (arr5[i] < min) {
                min = arr5[i];
                min = arr5[i];
            }
        }
        System.out.println("Максимальное число массива: " + max);
        System.out.println("Минимальное число массива: " + min);

        int[] arr6 = {5, 4, 6, 5, 5, 5};
        System.out.println("\nЗадание №6\n" + checkBalance(arr6));

        System.out.println("\nЗадание №7\n");
        int[] arrShift1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n1 = 5;
        shiftArray(arrShift1, n1);

    }
// Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

    public static boolean checkBalance(int[] arrParam) {
        int lSum, rSum;

        for (int i = 0; i < arrParam.length + 1; i++) {
            lSum = 0;
            rSum = 0;

            for (int j = 0; j < i; j++) {
                lSum += arrParam[j];
            }

            for (int j = i; j < arrParam.length; j++) {
                rSum += arrParam[j];
            }

            if (lSum == rSum) return true;
        }
        return false;
    }

    public static void shiftArray(int[] arr, int shift){
        System.out.println("До сдвига:" + Arrays.toString(arr));
        System.out.println("Длина сдвига:" + shift);
        int length = arr.length;

        if (shift > 0) {
            for (int i = 0; i < shift; i++) {
                int buffer = arr[length - 1];
                System.arraycopy(arr, 0, arr, 1, length - 1);
                arr[0] = buffer;
            }
        } else if (shift < 0) {
            for (int i = 0; i < -shift; i++) {
                int buffer = arr[0];
                System.arraycopy(arr, 1, arr, 0, length - 1);
                arr[length - 1] = buffer;
            }
        }
        System.out.print("Массив после сдвига:\t" + Arrays.toString(arr) + "\n\n");

    }
}
