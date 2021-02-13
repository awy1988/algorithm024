package Week_03.course;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *  
 *
 * 提示：
 *
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PowXN {
    /**
     * 暴力解法
     * 暴力解法在leetcode上是无法通过提交的，因为最后会超出时间限制。
     * 比如这样的case：
     * 1.00000
     * 2147483647
     * 1的2147483647次方
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        double result = 1;
        double absN = n > 0 ? n : -n;
        for(int i = 0; i < absN; i++) {
            result *= x;
        }
        return n > 0 ? result : 1 / result;
    }

    /**
     * 分治方式（也就是递归）解决问题
     * 思路：
     * 首先处理n，因为n的范围可以是负数，所以当n为负数时，我们需要对n进行处理，并对结果进行转换。
     * 然后是递归的逻辑：
     * 这个问题中，我们想求x的n次方，那么我们可以将问题转化为:
     * 当 x 为奇数时：
     * x^n = x^(n/2) * x^(n/2) * x;
     * 当 x 为偶数时：
     * x^n = x^(n/2) * x^(n/2)
     * 这个解法就是给这道题加速的关键。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        double result = 1;
        int absN = n;
        if (n < 0) absN = -n;
        result = pow2(x, absN);
        return n > 0 ? result : 1 / result;

    }

    private double pow2(double x, int n) {
        double result = 1;
        // terminator
        if (n == 0) return result;

        // process
        // drill down
        // reverse state
        // 这里有一个注意点，在进行计算的时候，一定要用一个half这样的中间结果来接计算之后的值。
        // 不能直接将计算half的方法代入到 result = half * half; 和 result = half * half * x;中，
        // 因为这样做的话，会导致调用的栈太多，实际上可能时间复杂度还不如直接循环。
        double half = pow2(x, n / 2);
        if (n%2 == 0) {
            // 偶数
            result = half * half;
        } else {
            // 奇数
            result = half * half * x;
        }
        return result;
    }



    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow1(2, -2));
        System.out.println(powXN.myPow2(2, -2));
    }
}
