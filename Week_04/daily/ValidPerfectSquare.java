package Week_04.daily;

/**
 * 367. 有效的完全平方数
 *
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPerfectSquare {

    public boolean isPerfectSquare1(int num) {
        if (num < 2) return true;
        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) return true;
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        String numStr = String.valueOf(num);
        int length = numStr.length();
        int halfLength = 0;
        if (length % 2 == 0){
            halfLength = length/2;
        } else {
            halfLength = length/2 + 1;
        }
        int max = 1;
        for (int i = 1; i <= halfLength; i++) {
            max *= 10;
        }
        max = max - 1;
        for (int i = 1; i <= max; i++) {
            if (num == i*i) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        System.out.println(validPerfectSquare.isPerfectSquare1(808201));
        System.out.println(validPerfectSquare.isPerfectSquare2(808201));
        System.out.println(1000 * 1000);
    }
}
