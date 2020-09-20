/**
 * @author danger
 * @date 2020/9/20
 */

/*
给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

 子数组 定义为原数组中的一个连续子序列。

 请你返回 arr 中 所有奇数长度子数组的和 。



 示例 1：

 输入：arr = [1,4,2,5,3]
输出：58
解释：所有奇数长度子数组和它们的和为：
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

 示例 2：

 输入：arr = [1,2]
输出：3
解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。

 示例 3：

 输入：arr = [10,11,12]
输出：66




 提示：


 1 <= arr.length <= 100
 1 <= arr[i] <= 1000

 Related Topics 数组
*/

public class SumOddLengthSubarrays {
    /**
     * 暴力解法
     */
    public int sumOddLengthSubarrays1(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i = 1; i <= len; i=i+2) {
            for (int j = 0; j < len - i + 1; j++) {
                for (int k = j; k < j + i; k++) {
                    sum += arr[k];
                }
            }
        }
        return sum;
    }

    /**
     * 规律解法
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 出现的次数等于 左边奇数选择 * 右边奇数选择 + 左边偶数选择 * 右边偶数选择
            int times = ((i+1)/2)*((n-i)/2) + ((i+1+1)/2)*((n-i+1)/2);
            sum = sum + arr[i] * times;
        }
        return sum;
    }
}
