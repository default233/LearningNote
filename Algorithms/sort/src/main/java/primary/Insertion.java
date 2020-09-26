package primary;

import java.util.Arrays;

/**
 * 插入排序算法
 * 算法思路：类似于我们打扑克牌时，之前的数组都是排好序的，每次新来一张扑克牌时，就将其插入到对应的位置
 * 时间复杂度：O(n^2)，当数组正好倒叙排列时，仍需要每两个数都比较一次
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author danger
 * @date 2020/9/12
 */
public class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[]{9,8,8,6,5,4,2,3,1};
//        Integer[] arr = new Integer[]{9,7,8,6,5,4,2,3,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 用于排列简单数组的插入排序，升序
     * @param arr 待排序的数组
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 用于排列实现了comparable接口的引用数组插入排序，升序
     * @param arr 待排序的数组
     */
    public static void insertSort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (arr[j+1].compareTo(arr[j]) < 0) {
                    Comparable temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

}
