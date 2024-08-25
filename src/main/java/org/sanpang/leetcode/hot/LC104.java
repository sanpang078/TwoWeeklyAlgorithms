package org.sanpang.leetcode.hot;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LC104 {
/*https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked
    给定一个二叉树 root ，返回其最大深度。
    二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
    输入：root = [3,9,20,null,null,15,7]
    输出：3
    示例 2：
    输入：root = [1,null,2]
    输出：2
* */
    public static void main(String[] args) {
        List<Object> list = Arrays.asList(3, 9, 20, null, null, 15, 7);
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);

        TreeNode root = buildTree(nums);
        System.out.println(maxDepth(root));
    }


    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0) return null;

        TreeNode root = new TreeNode(nums[0]);
        int i = 1; // 从数组的第二个元素开始遍历
        buildLeftRight(root, nums, i);
        return root;
    }
    private static void buildLeftRight(TreeNode node, Integer[] nums, int i) {
        // 添加左子节点
        if (i < nums.length && nums[i] != null) {
            node.left = new TreeNode(nums[i]);
            i++; // 移动到下一个元素
            buildLeftRight(node.left, nums, 2 * i + 1); // 递归构建左子树
        }

        // 添加右子节点
        i++; // 跳过左子节点
        if (i < nums.length && nums[i] != null) {
            node.right = new TreeNode(nums[i]);
            i++; // 移动到下一个元素
            buildLeftRight(node.right, nums, 2 * i + 1); // 递归构建右子树
        }
    }

    public static int maxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

