package heap;

import java.util.Arrays;

/**
 *
 * 堆排序算法
 * 算法思路：利用堆这种数据结构，每次将堆顶元素取出，即可正确排序
 * 时间复杂度：O(nlog n)，堆的维护需要 O(log n)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author danger
 * @date 2020/9/26
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {9,8,7,5,7,2,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapSort(int[] arr) {
        int n = arr.length;
        /**
         * 先将数组构建为堆，由于每个叶子节点都视为一个子堆，而堆的叶子节点一共有 n/2 个，因此我们对前 n/2 个节点进行下沉就可以形成
         * 堆
         */
        for (int i = n/2-1; i >= 0 ; i--) {
            sink(arr, i, n);
        }
        while (n >= 1) {
            //交换堆顶元素至数组的末尾，相当于是将堆顶元素移除
            int temp = arr[0];
            arr[0] = arr[n-1];
            arr[n-1] = temp;
            n--;
            // 进行堆的修复
            sink(arr, 0, n);
        }
    }

    private static void sink(int[] arr, int i, int n) {
        // 对节点 i 进行堆的下沉
        // 节点 i 的子树节点为 2*i + 1 和 2*i + 2，我们需要找出节点中较大的数与当前节点交换
        while (2*i + 1 < n) {
            int j = 2*i+1;
            if (j + 1< n && arr[j] < arr[j+1])
                j++;
            if (arr[i] > arr[j])
                break;
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            i = j;
        }
    }
}
