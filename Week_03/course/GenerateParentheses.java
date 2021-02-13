package Week_03.course;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParentheses {

    private ArrayList<String> result;

    /**
     * 典型的递归题目
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        // terminator
        // 将题目抽象成，有N个格子，每种格子有两种可能性，问一共有多少种可能性
        //
        result = new ArrayList<>();
        _generate(0, 0, n, "");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        // terminator
        if (left == n && right == n) {

            // filter the invalid s
            result.add(s);
            return;
        }
        // process current logic: left, right
        // left 随时可以加，只要别超标
        // right 左个数 > 右个数必须之前有左括号，且左括号的个数要大于右个数

        // drill down
        if (left < n)
            _generate(left + 1, right, n,s + "(");
        if (left > right)
            _generate(left, right + 1, n,s + ")");

        // reverse states

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
}
