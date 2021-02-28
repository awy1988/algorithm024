package Week_04.daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *  
 *
 * 进阶：
 *
 * 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
    /**
     * 常规解法，循环遍历，记录每个元素出现的次数
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> resultMap = new HashMap<>();

        for(int i : nums) {
            int count = resultMap.getOrDefault(i, 0);
            resultMap.put(i, ++count);
        }
        int mostCount = 0;
        int result = 0;
        for (Integer element :
                resultMap.keySet()) {
            if (resultMap.get(element) > mostCount) {
                mostCount = resultMap.get(element);
                result = element;
            }
        }
        return result;
    }

    /**
     * 排序，返回中间元素
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count = 0, element = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count++;
                continue;
            }
            if (nums[i] == element) {
                count++;
            } else {
                count--;
            }
        }
        return element;
    }


    public static void main(String[] args) {
        MajorityElement majorityElement = new MajorityElement();
        majorityElement.majorityElement1(new int[] {3,2,3});
    }
}
