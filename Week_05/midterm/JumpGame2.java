package Week_05.midterm;

/**
 * 45. 跳跃游戏 II
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 *
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 *
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class JumpGame2 {


    private int theStepToLast = 0;
    public int jump1(int[] nums) {

        if (nums.length <= 1) return theStepToLast;
        theStepToLast = nums.length;
        canReachEnd(nums, 1, 0);
        return theStepToLast;
    }

    private boolean canReachEnd(int[] nums, int count, int startIndex) {
        // termanitor
        int stepCount = nums[startIndex];

        if (startIndex + stepCount >= nums.length - 1) {
            theStepToLast = Math.min(theStepToLast, count);
            return true;
        }

        // process
        for(int i = startIndex + 1; i <= stepCount + startIndex; i++) {
            if (nums[i] + i >= nums.length - 1) {
                theStepToLast = Math.min(theStepToLast, count + 1);
                return true;
            }
        }

        int max = nums[startIndex + 1] + startIndex + 1;
        int maxIndex = startIndex + 1;
        for(int i = startIndex + 1; i <= stepCount + startIndex; i++) {
            if (nums[i] + i > max) {
                max = nums[i] + i;
                maxIndex = i;
            }
        } // drill down
        canReachEnd(nums, count + 1, maxIndex);
        return false;
        // reverse state
    }

    /**
     * 贪心算法
     * 每次取当前节点能够触达范围内，能够跳的最远的节点作为下一次跳跃的起点。
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGame2 jumpGame2 = new JumpGame2();
//        System.out.println(jumpGame2.jump1(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
//        System.out.println(jumpGame2.jump2(new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
        System.out.println(jumpGame2.jump2(new int[]{2,3,1,1,4}));
    }

}
