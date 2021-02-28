package Week_01.basic;

import Week_02.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 深度优先与广度优先
 */
public class DFSAndBFS {
    /**
     * 深度优先
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
    }

    /**
     * 广度优先
     * @param root
     */
    public void bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }
}
