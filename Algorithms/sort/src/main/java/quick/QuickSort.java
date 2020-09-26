package quick;

import java.util.Arrays;

/**
 * 快速排序算法
 * 算法思路：采用分治思想，选择一个分割点，将数组分为两个子数组，使得比分割点小的数都在分割点左边，比分割点大的数都在分割点右边，递归处理子数组
 * 时间复杂度：O(nlog n)
 * 空间复杂度：O(1)，递归占用空间 O(log n)
 * 稳定性：不稳定
 *
 * 改进方式
 * 一、在排序规模较小时，改进为插入排序算法
 * 二、随机选择基准值
 * 三、三数取中选择基准值
 *
 * @author danger
 * @date 2020/9/23
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,5,7,2,1};
        quicksort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序函数入口
     */
    public static void quicksort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    /**
     * 数组快速排序主函数，升序
     * @param arr 待排序的数组
     * @param low 排序起始位置
     * @param high 排序末位置（包含）
     */
    private static void sort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int j = partition(arr, low, high);
        sort(arr, low, j-1);
        sort(arr,j+1, high);
    }

    /**
     * 返回分隔点，分割点左侧的数字都比分割点小，分割点右侧的数字都比分割点大
     * @param arr 待处理的数组
     * @param low 数组的起始位置
     * @param high 数组的末尾位置
     * @return 返回以确定的分割位置
     */
    private static int partition(int[] arr, int low, int high) {
        int left = low+1;
        int right = high;
        int temp = arr[low];
        while (true) {
            while (arr[left] < temp) {
                left++;
                if (left == high)
                    break;
            }
            while (arr[right] > temp) {
                right--;
                if (right == low)
                    break;
            }
            if (left >= right)
                break;
        }
        arr[low] = arr[right];
        arr[right] = temp;
        return right;
    }
}
