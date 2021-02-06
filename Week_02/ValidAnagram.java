package Week_02;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidAnagram {
    // 思路：
    // 1.使用哈希表法，这个跟 IntersactonOfTwoArrays2 有点像，循环第一个字符串，
    // 将出现的字符作为键，出现的次数做为值存起来，然后在循环第二个字符串，当字符串最后可以
    // 将hashMap中的所有元素减为0时，认为这两个字符串满足条件，是字母异位词
    public boolean isAnagram(String s, String t) {
        // 哈希表
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            count++;
            map.put(s.charAt(i), count);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null) {
                return false;
            }
            count--;
            if (count == 0) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), count);
            }
        }
        return map.isEmpty();
    }

    // 2.暴力解法，先排序，然后判断字符串相等。
    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        String s1 = new String(charArray1);
        String s2 = new String(charArray2);
        return s1.equals(s2);

    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("anagram", "nagaram");
        validAnagram.isAnagram2("a", "b");
    }
}
