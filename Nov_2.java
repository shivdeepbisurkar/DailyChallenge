//Count Nodes Equal to Average of Subtree
/*
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
 */

class Solution {
    int res = 0;

    public int averageOfSubtree(TreeNode root) {
        int sum = 0, cnt = 0;
        int ans[] = help(root, sum, cnt);
        return res;
    }

    public int[] help(TreeNode root, int sum, int cnt) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int leftSum[] = help(root.left, sum, cnt);
        int rightSum[] = help(root.right, sum, cnt);
        int totalSum = leftSum[0] + rightSum[0] + root.val;
        int totalCount = 1 + leftSum[1] + rightSum[1];

        if (totalSum / totalCount == root.val) {
            System.out.println("totalSum:" + totalSum + "  " + "count" + totalCount);
            res++;
        }

        return new int[] { totalSum, totalCount };
    }
}
