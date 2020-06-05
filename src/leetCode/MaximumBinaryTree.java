package leetCode;

import treesAndGraphs.TreeNode;

import java.util.Arrays;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums);

    }

    public TreeNode helper(int[]nums){
        if (nums.length == 0) return null;

        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > nums[maxIndex])
                maxIndex = i;

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, nums.length));

        return root;
    }
}
