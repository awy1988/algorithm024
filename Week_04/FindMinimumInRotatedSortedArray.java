package Week_04;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 *
 * 请找出其中最小的元素。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2]
 * 输出：0
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinimumInRotatedSortedArray {

    /**
     * 二分查找
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        int result = 0;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (mid == start || mid == end) {
                result = nums[start] > nums[end] ? nums[end] : nums[start];
                break;
            }
            // 前面单增，最小值在后面
            if (nums[mid] > nums[start]) {
                start = mid; // 注意，此时start可能是最小值
                mid = (start + end) / 2;
                continue;
            }
            // 后面单增，最小值在前面
            if (nums[mid] < nums[end]) {
                end = mid; // mid可能是最小值，所以不能等于 mid - 1
                mid = (start + end) / 2;
                continue;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        System.out.println(findMinimumInRotatedSortedArray.findMin1(new int[] {4,5,6,7,8,0,1,2}));
    }
}
