package Week_03.course;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSets {

    /**
     * 递归方式解决该问题
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) return ans;
        dfs(ans, nums, new ArrayList<Integer>(), 0);
        return ans;
    }
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        // terminator
        if (index == nums.length) {
            ans.add(new ArrayList<Integer>(list));
            return;
        }

        // not pick the number at this index
        dfs(ans, nums, list, index + 1);

        list.add(nums[index]);

        // pick the number at this index
        dfs(ans, nums, list, index + 1);

        // reverse the current state
        list.remove(list.size() - 1);
    }

    /**
     * 迭代方式解决该问题
     * 这个方法比较好理解，做法就是每次从数组中取出一个新的元素，并将这个元素分别插入到之前所有生成的集合中。
     * 比如：[1,2,3]
     * 这个中间过程如下：
     * 初始状态：[]
     * 插入1生成：[1]
     * 插入2生成：[2],[1,2]
     * 插入3生成：[3],[1,3],[2,3],[1,2,3]
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) return result;
        result.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> resultTobeAdded = new ArrayList<>();
            for (List<Integer> element : result){
                List<Integer> newElement = new ArrayList<>(element);
                newElement.add(nums[i]);
                resultTobeAdded.add(newElement);
            }
            result.addAll(resultTobeAdded);
        }
        return result;
    }
}
