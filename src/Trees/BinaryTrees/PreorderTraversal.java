package Trees.BinaryTrees;
import Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PreorderTraversal {

    public static List<Integer> preOrder(TreeNode head) {
        var list = new ArrayList<Integer>();
        if(head == null) return list;
        
        list.add(head.val);
        
        list.addAll(preOrder(head.left));
        list.addAll(preOrder(head.right));

        return list;
    }
    
    public static void main(String[] args) {
        var head = new TreeNode(100);
        var head1 = new TreeNode(200);
        var head2 = new TreeNode(300);
        var head3 = new TreeNode(400);
        var head4 = new TreeNode(500);
        var head5 = new TreeNode(600);
        var head6 = new TreeNode(700);
        
        head.left = head1;
        head.right = head2;
        
        head1.left = head3;
        head1.right = head4;
        
        head2.left = head5;
        head2.right = head6;
        
        var list = preOrder(head);
        for(var e: list) System.out.print(e+", ");
    }
}
