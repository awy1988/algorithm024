package Week_01;

/**
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
 */
public class MoveZeros {

    public void moveZeroes(int[] nums) {
        // 采用一次遍历交换元素的解法
        // 这个解法的优势是：只需要遍历一次即可
        // 这个解法的劣势是：如果数组中所有的元素都不为0，这种情况下也需要n次交换。
        int notZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // 交换元素
                int temp = nums[i];
                nums[i] = nums[notZeroIndex];
                nums[notZeroIndex] = temp;
                notZeroIndex++;
            }
        }
    }

    /**
     * 训练营超哥题解
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    // 如果 i = j,那么不能将i处的结果设置为0，因为要保证 j 指向的内容不为0
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
