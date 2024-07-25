package Trees.BinaryTrees;

import Trees.TreeNode;

public class MaximumPathSum {
    
    
    
    public static int maximumPathSum(TreeNode root) {
        if(root == null) return Integer.MIN_VALUE;
        
        var leftTreeSum = maximumPathSum(root.left);
        var rightTreeSum = maximumPathSum(root.right);
        
        var maxSum = Math.max(root.val, leftTreeSum);
        maxSum = Math.max(maxSum, rightTreeSum);
        maxSum = Math.max(maxSum, leftTreeSum + root.val + rightTreeSum);
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        var head = new TreeNode(100);
        var head1 = new TreeNode(200);
//        var head2 = new TreeNode(300);
//        var head3 = new TreeNode(400);
//        var head4 = new TreeNode(500);
//        var head5 = new TreeNode(600);
//        var head6 = new TreeNode(700);

        head.left = head1;
//        head.right = head2;
//
//        head1.left = head3;
//        head1.right = head4;
//
//        head2.left = head5;
//        head2.right = head6;

        System.out.println(maximumPathSum(head));
    }
}
