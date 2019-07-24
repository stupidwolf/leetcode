package xyz.stupidwolf;

import org.apache.regexp.RE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Symmetric_Tree_101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
           TreeNode node1 = stack.pop();
           TreeNode node2 = stack.pop();
           if (node1 == null && node2 == null) {
               continue;
           }
           if (node1 == null || node2 == null) {
               return false;
           }
           if (node1.val != node2.val) {
               return false;
           }
           stack.push(node1.left);
           stack.push(node2.right);
           stack.push(node1.right);
           stack.push(node2.left);
        }
        return true;
    }
}
