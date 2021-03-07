package Week_01;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeSortedArray {

    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        // 本题的解法为：数组从后向前遍历
        int nums1Index = m - 1, nums2Index = n - 1;
        for (int i = m + n - 1; i >= 0 ; i--) {
            if (nums1Index == -1) {
                if (nums2Index == -1) break;
                nums1[i] = nums2[nums2Index--];
                continue;
            }
            if (nums2Index == -1) {
                break;
            }
            if (nums1[nums1Index] >= nums2[nums2Index]) {
                nums1[i] = nums1[nums1Index--];
                continue;
            }
            nums1[i] = nums2[nums2Index--];
        }
    }

    /**
     * 思路也是从后向前遍历，但是比merge1中的代码要优雅许多。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int currentIndex = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            nums1[currentIndex--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if (p1 < 0) System.arraycopy(nums2, 0, nums1,0,p2 + 1);
    }
}
