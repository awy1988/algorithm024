package Week_03;

import Week_02.TreeNode;

import java.util.LinkedList;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 *
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *  
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * 通过次数157,769提交次数237,739
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestorOfABinaryTree {
    /**
     * 解法一：
     * 这是自己的思路
     * 首先，将树按照层序遍历的方式，将所有非叶子节点入栈（因为只有非叶子节点才有可能是两个节点的共同祖先）
     * 然后，从栈中取出元素，递归进行判断，该元素是否为两个节点的共同祖先，如果是，那么这个就是最近公共祖先，如果不是，那么继续判断。
     * 由于入栈时采用层序遍历的方式，所以从栈顶弹出的元素顺序是按照从下层开始向上层的排序方式。
     * 所以找到的第一个公共祖先，一定是在树中能找到的最下面的层级。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        createTreeLevelStack(root, stack);
        while (!stack.isEmpty()) {
            node = stack.pollLast();
            if (isAncestor(node, p) && isAncestor(node, q)) return node;
        }
        return node;
    }

    /**
     * 返回这棵树的层级遍历的栈
     * @param root
     */
    private void createTreeLevelStack(TreeNode root, LinkedList<TreeNode> stack) {
        if (root == null) return;
        if (root.left != null || root.right != null) {
            stack.add(root);
        }
        if (root.left != null) createTreeLevelStack(root.left, stack);
        if (root.right != null) createTreeLevelStack(root.right, stack);
    }

    /**
     * 判断某个节点是否为某个根的祖先
     * @param root
     * @param p
     * @return
     */
    private boolean isAncestor(TreeNode root, TreeNode p) {
        boolean isAncestor = false;
        // terminator
        if (root.val == p.val) {
            return true;
        }

        // process logic
        if (root.left != null) {
            isAncestor = isAncestor(root.left, p);
        }
        if (isAncestor) return true;

        if (root.right != null) {
            isAncestor = isAncestor(root.right, p);
        }
        return isAncestor;
        // drill down
    }


    /**
     * 递归解法
     * 思路：
     * 最近的公共祖先，必须满足：p和q分别在该祖先的左右子树中。
     * 如果p或q不满足这个条件，那么就说明p或q本身就是二者的最近公共祖先。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null) {
            if (right != null) {
                return root;
            }
            return left;
        }
        return right;

    }

}
