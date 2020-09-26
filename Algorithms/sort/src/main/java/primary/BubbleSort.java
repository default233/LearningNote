package primary;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * 算法思路：每次遍历数组，一次比较两个元素，如果它们的顺序错误就把它们交换过来，越大的元素会经由交换慢慢“浮”到数列的顶端。
 * 时间复杂度 O(n^2)
 * 空间复杂度 O(1)
 * 稳定性：稳定
 *
 * @author danger
 * @date 2020/9/26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,5,7,2,1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序算法，升序排列
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false; // 交换标记
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) //没有发生交换时排序停止
                break;
        }
    }
}
