package g1101_1200.s1110_delete_nodes_and_return_forest;

// #Medium #Depth_First_Search #Tree #Binary_Tree
// #2022_03_01_Time_5_ms_(15.90%)_Space_42.4_MB_(87.43%)

import com_github_leetcode.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int d : toDelete) {
            delete(d, queue);
        }
        List<TreeNode> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    private void delete(int toDelete, Queue<TreeNode> queue) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode curr = queue.poll();
            if (delete(curr, toDelete, queue)) {
                if (toDelete != curr.val) {
                    queue.offer(curr);
                }
                break;
            } else {
                queue.offer(curr);
            }
        }
    }

    private boolean delete(TreeNode curr, int toDelete, Queue<TreeNode> queue) {
        if (curr == null) {
            return false;
        } else {
            if (curr.val == toDelete) {
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
                return true;
            } else if (curr.left != null && curr.left.val == toDelete) {
                if (curr.left.left != null) {
                    queue.offer(curr.left.left);
                }
                if (curr.left.right != null) {
                    queue.offer(curr.left.right);
                }
                curr.left = null;
                return true;
            } else if (curr.right != null && curr.right.val == toDelete) {
                if (curr.right.left != null) {
                    queue.offer(curr.right.left);
                }
                if (curr.right.right != null) {
                    queue.offer(curr.right.right);
                }
                curr.right = null;
                return true;
            }
            return delete(curr.left, toDelete, queue) || delete(curr.right, toDelete, queue);
        }
    }
}
