package primary;

import java.util.Arrays;

/**
 * 希尔排序算法
 * 算法思路：将数组按间隔划分为若干子序列，对每个子序列进行插入排序，然后逐渐缩小间隔直至1，这样就使得插入排序中，每次需要
 * 移动的数能够移动较长的距离，同时其每个递增子序列也为后续的插入排序提供了便利条件
 * 时间复杂度：O(n^(1.3—2))，根据不同的间隔数大小有不同的时间复杂度结果
 * 空间复杂度：O(1)
 * @author danger
 * @date 2020/9/18
 */
public class ShellSort {

    public static void main(String[] args) {
//        int[] arr = new int[]{9,8,8,6,5,4,2,3,1};
        Integer[] arr = new Integer[]{9,7,8,6,5,4,2,3,1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 用于排列简单数组的希尔排序，升序
     * @param arr 待排序的数组
     */
    public static void shellSort(int[] arr) {
        int h = 1;
        int len = arr.length;
        while (h < len/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j] <= arr[j-h]) {
                        int temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    } else {
                        break;
                    }

                }
            }
            h = h/3;
        }
    }


    /**
     * 用于排列实现了comparable接口的引用数组希尔排序，升序
     * @param arr 待排序的数组
     */
    public static void shellSort(Comparable[] arr) {
        int h = 1;
        int len = arr.length;
        while (h < len/3) {
            h = 3*h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < len; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j].compareTo(arr[j-h]) <= 0) {
                        Comparable temp = arr[j];
                        arr[j] = arr[j-h];
                        arr[j-h] = temp;
                    } else {
                        break;
                    }

                }
            }
            h = h/3;
        }
    }

}
