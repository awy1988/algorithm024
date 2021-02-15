package Week_03.course;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 * 示例 1：
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 *
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 *
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Integer, String> dictionary = new HashMap<>();
        dictionary.put(2, "abc");
        dictionary.put(3, "def");
        dictionary.put(4, "ghi");
        dictionary.put(5, "jkl");
        dictionary.put(6, "mno");
        dictionary.put(7, "pqrs");
        dictionary.put(8, "tuv");
        dictionary.put(9, "wxyz");

        generateCombinations(dictionary, digits, "", result);
        return result;
    }

    private void generateCombinations(Map<Integer, String> dictionary, String digits, String resultStr, List<String> result) {
        // terminator
        if ("".equals(digits) || null == digits) {
            if(resultStr != null && resultStr.length() != 0) result.add(resultStr);
            return;
        }
        // process
        // 取第一个数字，将其内容加入resultStr
        int levelNumber = Integer.parseInt(digits.substring(0, 1));
        String levelString = dictionary.get(levelNumber);
        for (int i = 0; i < levelString.length(); i++) {
            generateCombinations(dictionary, digits.substring(1), resultStr + levelString.charAt(i), result);
        }
        // drill down

        // reverse states
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println("ab".substring(1));
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("234"));
    }
}
