package Week_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NAryTreePreorderTraversal {
    /**
     * 递归方式实现N叉数的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorder(root, result);
        return result;
    }

    private void preorder(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.children == null) {
            return;
        }
        for (Node child : node.children) {
            preorder(child, result);
        }
    }

    /**
     * 迭代方式实现
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();

        return result;
    }
}
