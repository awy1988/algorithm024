package Week_03.Daily;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReplaceSpace {

    /**
     * 凡是做Java的人，第一个想到的都应该是：利用系统提供的方法
     * @return
     */
    public String replaceSpace1(String s) {
        return s.replace(" ", "%20");
    }

    /**
     * 不直接使用系统自带的情况下，我们也可以充分利用JavaAPI的优势，
     * 使用StringBuilder来做缓冲区，进行字符的拼接
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
