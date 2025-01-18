package mergetwoarrays;

import java.util.Arrays;
/**
 * Задача — Объединяем массивы <br>
 * Даны 2 целочисленных массива nums1 и nums2, они отсортированы в неубывающем порядке. И 2 числа m и n, которые представляют количество элементов массивов nums1 и nums2 соответственно. <br><br>
 * Объедините nums1 и nums2 в один массив, элементы которого отсортированы в неубывающем порядке. <br><br>
 * Конечный отсортированный массив не должен быть возвращен функцией, а вместо этого должен храниться внутри массива nums1. В связи с этим, nums1 имеет длину m + n, где первые m элементов обозначают элементы, которые должны быть объединены, а последние n элементов имеют значение 0 и должны игнорироваться.
 * */
public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] nums1 ={0}, nums2 ={1};
        int m = 0, n = 1;
        new MergeTwoArrays().merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //pointers будут указывать на концы массивов
        int pointerNums1 = m - 1, pointerNums2 = n - 1, pointer = m + n - 1 ;

        //продолжаем цикл пока не пройдем весь массив
        while (pointer >= 0) {
            //если второй массив пустой, то нет смысла дальше идти, просто оставляем все как есть
            if (pointerNums2 < 0)
                break;

            //если у первого массива есть элементы (кроме 0 которые служат для заполнения) и текущий элемент первого массива меньше или равно чем элемент второго массива то сохраняем его.
            if (pointerNums1 >= 0 && nums1[pointerNums1] >= nums2[pointerNums2]) {
                nums1[pointer] = nums1[pointerNums1];
                pointerNums1--;
            } else {
                nums1[pointer] = nums2[pointerNums2];
                pointerNums2--;
            }
            pointer--;
        }
    }

    //Первое решение с использованием доп массива
    public void mergeFor(int[] nums1, int m, int[] nums2, int n) {
        int[] copyOfNums1 = Arrays.copyOf(nums1, nums1.length);
        int j = 0, k = 0;

        for (int i = 0; i < m + n; i++) {
            if (n == 0 || copyOfNums1.length == 0)
                return;

            if (k == n || j < m && copyOfNums1[j] <= nums2[k]) {
                nums1[i] = copyOfNums1[j];
                j++;
            }
            else {
                nums1[i] = nums2[k];
                k++;
            }
        }
    }
}
