package Week_03.course;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClimbingStairs {

    // 爬楼梯这道题目，实际上就是斐波那契数列。
    // 这道题的最核心问题是思维过程：
    // 第一级台阶，我们只有一种方法，
    // 第二级台阶，有两种方法，
    // 第三级台阶，第三级台阶的所有上法等于第二级台阶的走法 + 第一级台阶的走法。
    // 同理，第四级台阶的走法 = 第三级台阶的走法 + 第二级台阶的走法
    // 最后我们会发现这样的通项公式：f(x)=f(x−1)+f(x−2)
    // 这其实就是斐波那契数列
    // 所以这道题其实就是让我们求斐波那契数列的第n项

    /**
     * 带有缓存的递归
     */
    Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs1(int n) {
        Integer cachedNum = cache.get(n);
        if (cachedNum != null) return cachedNum;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int result = climbStairs1( n - 1) + climbStairs1( n - 2);
        cache.put(n, result);
        return result;
    }

    /**
     * 动态规划之滚动数组
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
