package Week_04.course;

import Week_02.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindLargestValueInEachTreeRow {
    List<Integer> result = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        getResult(0, queue);
        return result;
    }

    private void getResult(int level, LinkedList<TreeNode> queueInThisLevel) {
        if (queueInThisLevel.isEmpty()) return;
        LinkedList<TreeNode> nextLevelQueue = new LinkedList<>();
        result.add(level,queueInThisLevel.peekFirst().val);
        while (!queueInThisLevel.isEmpty()) {
            TreeNode node = queueInThisLevel.pollFirst();
            if (node == null) continue;
            if (node.val > result.get(level))  result.set(level, node.val);
            if (node.left != null) nextLevelQueue.add(node.left);
            if (node.right != null) nextLevelQueue.add(node.right);
        }
        getResult(level + 1, nextLevelQueue);
    }
}
