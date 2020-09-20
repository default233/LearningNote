import java.util.HashMap;
import java.util.Map;

/**
 * @author danger
 * @date 2020/9/20
 */

/*给你一个正整数数组 nums，请你移除 最短 子数组（可以为 空），使得剩余元素的 和 能被 p 整除。 不允许 将整个数组都移除。

 请你返回你需要移除的最短子数组，如果无法满足题目要求，返回 -1 。

 子数组 定义为原数组中连续的一组元素。

示例 1：
输入：nums = [3,1,4,2], p = 6
输出：1
解释：nums 中元素和为 10，不能被 p 整除。我们可以移除子数组 [4] ，剩余元素的和为 6 。

示例 2：
输入：nums = [6,3,5,2], p = 9
输出：2
解释：我们无法移除任何一个元素使得和被 9 整除，最优方案是移除子数组 [5,2] ，剩余元素为 [6,3]，和为 9 。


 示例 3：
输入：nums = [1,2,3], p = 3
输出：0
解释：和恰好为 6 ，已经能被 3 整除了。所以我们不需要移除任何元素。

 示例 4：
输入：nums = [1,2,3], p = 7
输出：-1
解释：没有任何方案使得移除子数组后剩余元素的和被 7 整除。

 示例 5：
输入：nums = [1000000000,1000000000,1000000000], p = 3
输出：0


 提示：

 1 <= nums.length <= 105
 1 <= nums[i] <= 109
 1 <= p <= 109 */

public class MinSubArray {

    /**
     * 暴力解法
     */
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] % p;
        }
        if (sum % p ==0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i + 1; j++) {
                int inSum = 0;
                for (int k = j; k < j + i; k++) {
                    inSum += nums[k] % p;
                }
                if ((sum - inSum) % p == 0)
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {8,32,31,18,34,20,21,13,1,27,23,22,11,15,30,4,2};
        minSubarray2(arr, 148);
    }
    /**
     * 前缀和加哈希
     */
    public static int minSubarray2(int[] nums, int p) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int mod = (int) (sum % p);
        if (mod == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        long preSum = 0;
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int preMod = (int) (preSum % p);
            map.put(preMod, i);
            int targetMod = preMod - mod >= 0 ? (preMod - mod) : (preMod - mod + p);
            if (map.containsKey(targetMod))
                ans = Math.min(i - map.get(targetMod), ans);
        }
        return ans == nums.length ? -1 : ans;
    }
}
