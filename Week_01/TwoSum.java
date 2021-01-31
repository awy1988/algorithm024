package Week_01;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    // 思路：
    // 1.暴力求解法，两层循环
    // 2.使用HashMap来求解，以空间换时间

    /**
     * 暴力求解法
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {

        // 双层循环
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[] { -1, -1};
    }

    /**
     * 空间换时间
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {

        // 本次使用空间换时间的方式。
        Map<Integer, Integer> dictionary = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (dictionary.containsKey(target - nums[i])) {
                return new int[] { dictionary.get(target - nums[i]), i};
            }
            dictionary.put(nums[i], i);
        }
        return new int[] { -1, -1};
    }
}
