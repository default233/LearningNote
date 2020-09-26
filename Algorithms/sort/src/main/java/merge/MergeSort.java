package merge;

import java.util.Arrays;
import java.util.Queue;

/**
 * 归并排序算法
 * 算法思路：采用分治思想，将数组分为两个子数组，将两个子数组排序后的结果合并到原数组中，递归处理子数组
 * 时间复杂度：O(nlog n)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * @author danger
 * @date 2020/9/23
 */
public class MergeSort {
    private static int[] temp;
    public static void main(String[] args) {
        int[] arr = {9,8,7,5,7,2,1};
        mergesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 归并排序函数入口
     */
    public static void mergesort(int arr[]) {
        temp = new int[arr.length];
        sort(arr, 0, arr.length-1);
    }

    /**
     * 归并排序算法
     * @param arr 待排序的数组
     * @param low 待排序起始位置
     * @param high 待排序终止位置
     */
    public static void sort(int arr[], int low, int high) {
        if (low >= high)
            return;
        int mid = low + (high - low)/2;
        sort(arr, low, mid);
        sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }

    /**
     * 将两个有序数组合并为一个数组
     * @param arr 待合并的数组
     * @param low 左数组的起始位置
     * @param mid 两个数组的分割点
     * @param high 右数组的终止位置
     */
    public static void merge(int arr[], int low, int mid, int high) {

        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int left = low;
        int right = mid + 1;
        for (int i = low; i <= high; i++) {
            if (left > mid) {
                arr[i] = temp[right++];
            } else if (right > high) {
                arr[i] = temp[left++];
            } else if (temp[left] < temp[right]) {
                arr[i] = temp[left++];
            } else {
                arr[i] = temp[right++];
            }
        }
    }
}
