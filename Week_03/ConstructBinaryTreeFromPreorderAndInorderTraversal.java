package Week_03;

import Week_02.TreeNode;

import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndexOfInorder = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                rootIndexOfInorder = i;
                break;
            }
        }
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, rootIndexOfInorder + 1);
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndexOfInorder);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, rootIndexOfInorder + 1, preorder.length);
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndexOfInorder + 1, inorder.length);
        if (leftPreOrder.length != 0 && leftInOrder.length != 0) root.left = buildTree(leftPreOrder, leftInOrder);
        if (rightPreOrder.length != 0 && rightInOrder.length != 0) root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal buildTree = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(buildTree.buildTree(preOrder, inOrder));
    }
}
