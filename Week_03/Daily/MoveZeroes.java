package Week_03.Daily;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        // 双指针法，将后面的非零元素向前移动
        // j为数组中第一个0元素下标
        // i为数组中0元素之后第一个非零元素下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (j == i) continue;
            if (nums[i] == 0 && nums[j] != 0) {
                j = i;
                continue;
            }
            if (nums[i] != 0 && nums[j] == 0) {
                nums[j++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
