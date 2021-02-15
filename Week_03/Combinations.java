package Week_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * (中等)
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combinations {
    /**
     * 解法一：
     * 个人想到的第一个解法，就是利用求子集的方式。
     * 首先将n变为数组，然后求出n的所有子集
     * 最后找出所有长度为k的子集
     * 采用迭代的方式，代码如下：
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine1(int n, int k) {
        // 这个题的本质其实就是求CnK,这是一个组合。如何用程序来返回所有的组合。这就是这个题目想问的
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> finalResult = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
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

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).size() == k) {
                finalResult.add(result.get(i));
            }
        }

        return finalResult;
    }

    /**
     * 递归解法
     * 回溯 + 剪枝
     * 构造树的思想 + 剪枝
     * 将所有的元素在一起，构造一棵深度为k的树，然后每次减少一个元素，继续构造深度为K的树，直到剩余的元素不足以继续构造深度为k的树为止。
     * 当深度为k的树构造完成之后，每次将构造完成的一个分支加入结果集。
     * 参见：https://leetcode-cn.com/problems/combinations/solution/hua-jie-suan-fa-77-zu-he-by-guanpengchn/
     */
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine2(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }
    private void getCombine(int n, int k, int start, List<Integer> list) {
        // terminator
        if (k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        // process
        for (int i = start; i <= n - k + 1 ; i++) {
            list.add(i);
            // drill down
            getCombine(n, k - 1, i + 1, list);
            // reverse state
            list.remove(list.size() - 1);
        }
    }
}
