package primary;

import java.util.Arrays;

/**
 * 选择排序算法
 * 算法思路：每次遍历数组，找到数组中最小的数，找到之后，与数组的对应位置交换
 * 时间复杂度 O(n^2) ：循环需要进行 n(n-1)/2 次
 * 空间复杂度 O(1) ：使用了 min 来记录最小索引，temp 用于交换
 * 稳定性：不稳定
 *
 * @author danger
 * @date 2020/9/12
 */
public class Selection {
    public static void main(String[] args) {
        int[] arr = new int[]{8,6,5,4,7,5,3,2,1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 用于排列简单数组的选择排序，升序
     * @param arr 待排序的数组
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] <= arr[min])
                    min = j;
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 用于排列实现了comparable接口的引用数组选择排序，升序
     * @param arr 待排序的数组
     */
    public static void selectSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) <= 0)
                    min = j;
                Comparable temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
