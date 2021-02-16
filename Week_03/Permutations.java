package Week_03;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    boolean[] isVisited;
    public List<List<Integer>> permute(int[] nums) {
        isVisited = new boolean[nums.length];
        getPermute(nums, new ArrayList<>());
        return result;
    }

    private void getPermute(int[] nums, List<Integer> middleResult) {
        if (middleResult.size() == nums.length) {
            result.add(new ArrayList<>(middleResult));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) continue;
            middleResult.add(nums[i]);
            isVisited[i] = true;
            getPermute(nums, middleResult);
            middleResult.remove(middleResult.size() - 1);
            isVisited[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{}));
    }
}
