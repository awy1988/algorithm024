package Week_05.daily;

import java.util.Arrays;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 *  
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 *
 * 输入: [1,3,2,6,5]
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0 || postorder.length == 1) return true;
        int root = postorder[postorder.length - 1];
        int middle = -1;
        for (int i = postorder.length - 2; i >= 1; i--) {
            if (postorder[i] > root && postorder[i - 1] < root) middle = i;
            if (postorder[i] < root && postorder[i - 1] > root) return false;
        }
        if (middle == -1) return verifyPostorder(Arrays.copyOfRange(postorder, 0, postorder.length - 1));

        // 判断以middle为界，一边大于根一边小于根
        for (int i = 0; i < middle; i++) {
            if (postorder[i] > root) return false;
        }
        for (int i = middle; i < postorder.length; i++) {
            if (postorder[i] < root) return false;
        }
        return verifyPostorder(Arrays.copyOfRange(postorder, 0, middle)) && verifyPostorder(Arrays.copyOfRange(postorder, middle, postorder.length - 1));
    }


    public static void main(String[] args) {
        Offer33 offer33 = new Offer33();
        System.out.println(offer33.verifyPostorder(new int[]{1,6,3,2,5}));
        System.out.println(offer33.verifyPostorder(new int[]{1,3,2,6,5}));
        System.out.println(offer33.verifyPostorder(new int[]{1,2,3,4,5}));
        System.out.println(offer33.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));

    }


}
