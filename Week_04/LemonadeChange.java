package Week_04;

import java.util.LinkedList;

/**
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 *
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 *
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 *
 * 注意，一开始你手头没有任何零钱。
 *
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * 示例 1：
 *
 * 输入：[5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 *
 * 输入：[5,5,10]
 * 输出：true
 * 示例 3：
 *
 * 输入：[10,10]
 * 输出：false
 * 示例 4：
 *
 * 输入：[5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lemonade-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LemonadeChange {
    /**
     * 直接使用int来计数
     * @param bills
     * @return
     */
    public boolean lemonadeChange1(int[] bills) {
        int fiveCount = 0, tenCount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveCount++;
                continue;
            }
            if (bill == 10) {
                fiveCount--;
                tenCount++;
            } else {
                // bill == 20
                if (tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else {
                    fiveCount -= 3;
                }
            }
            if (fiveCount < 0 || tenCount < 0) return false;
        }
        return true;
    }

    /**
     * 使用栈来实现，运行效率不如方法1.
     * @param bills
     * @return
     */
    public boolean lemonadeChange2(int[] bills) {
        LinkedList<Integer> stack5 = new LinkedList<>();
        LinkedList<Integer> stack10 = new LinkedList<>();
        for (int bill : bills) {
            if (bill == 5) {
                stack5.add(bill);
                continue;
            }
            if (bill == 10) {
                if (stack5.size() == 0) return false;
                stack5.pollLast();
                stack10.add(bill);
            }
            if (bill == 20) {
                if (stack5.size() == 0) return false;
                if (stack10.size() == 0 && stack5.size() < 3) return false;
                Integer result10 = stack10.pollLast();
                Integer result5 = stack5.pollLast();
                if (result10 == null) {
                    for (int i = 0; i < 2; i++) {
                        result5 = stack5.pollLast();
                    }
                }
                if (result5 == null) return false;
            }
        }
        return true;
    }
}
