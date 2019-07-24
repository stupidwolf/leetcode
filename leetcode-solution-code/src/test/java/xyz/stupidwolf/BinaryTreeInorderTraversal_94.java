package xyz.stupidwolf;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(TreeNode node, List<Integer> list) {
        if (node != null) {
            inOrder(node, list);
            list.add(node.val);
            inOrder(node.right, list);
        }
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
