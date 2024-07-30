package Trees.BinaryTrees;
import Trees.TreeNode;
import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    
    public static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        if(root == null) return list;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Map<Integer, List<Integer>>> widthHeightMapping = new TreeMap<>();
        Map<TreeNode, List<Integer>> nodeWidthHeightMapping = new HashMap<>();
        
        queue.add(root);
        nodeWidthHeightMapping.put(root, List.of(0, 0));
        
        Map<Integer, List<Integer>> heightMapping = new HashMap<>();
        heightMapping.put(0, List.of(root.val));
        widthHeightMapping.put(0, heightMapping);
        
        while (!queue.isEmpty()) {
            
            var top = queue.poll();
            
            var nodeWidthHeight = nodeWidthHeightMapping.get(top);
            var currentWidth = nodeWidthHeight.get(0);
            var currentHeight = nodeWidthHeight.get(1);
            
            if(top.left != null) {
                
                var newWidth = currentWidth-1;
                var newHeight = currentHeight+1;
                var newNode = top.left;
                
                if(!widthHeightMapping.containsKey(newWidth)) {
                    Map<Integer, List<Integer>> height = new HashMap<>();
                    height.put(newHeight, List.of(newNode.val));
                    
                    widthHeightMapping.put(newWidth, height);
                }
                
                else {
                    var width = widthHeightMapping.get(newWidth);
                    
                    if(!width.containsKey(newHeight)) {
                        Map<Integer, List<Integer>> height = new HashMap<>();
                        heightMapping.put(newHeight, List.of(newNode.val));

                        widthHeightMapping.put(newWidth, height);
                    }
                    
                    else {
                        
                        var heightList = width.get(newHeight);
                        heightList.add(newNode.val);

                        Map<Integer, List<Integer>> height = new HashMap<>();
                        heightMapping.put(newHeight, heightList);
                        
                        widthHeightMapping.put(newWidth, height);
                    }
                }
                
                nodeWidthHeightMapping.put(newNode, List.of(newWidth, newHeight));
                queue.add(newNode);
            }

            if(top.right != null) {

                var newWidth = currentWidth+1;
                var newHeight = currentHeight+1;
                var newNode = top.right;

                if(!widthHeightMapping.containsKey(newWidth)) {
                    Map<Integer, List<Integer>> height = new HashMap<>();
                    height.put(newHeight, List.of(newNode.val));

                    widthHeightMapping.put(newWidth, height);
                }

                else {
                    var width = widthHeightMapping.get(newWidth);

                    if(!width.containsKey(newHeight)) {
                        Map<Integer, List<Integer>> height = new HashMap<>();
                        heightMapping.put(newHeight, List.of(newNode.val));

                        widthHeightMapping.put(newWidth, height);
                    }

                    else {

                        var heightList = width.get(newHeight);
                        heightList.add(newNode.val);

                        Map<Integer, List<Integer>> height = new HashMap<>();
                        heightMapping.put(newHeight, heightList);

                        widthHeightMapping.put(newWidth, height);
                    }
                }

                nodeWidthHeightMapping.put(newNode, List.of(newWidth, newHeight));
                queue.add(newNode);
            }
            
        }
        
        for(var width: widthHeightMapping.keySet()) {

            System.out.println("Width "+ width);
            
            var widthMapping = widthHeightMapping.get(width); 
            List<Integer> subList = new ArrayList<>();
            
            for(var height: widthMapping.keySet()) {
                System.out.println("Height "+ height);
                System.out.println(Arrays.toString(widthMapping.get(height).toArray()));
                subList.addAll(widthMapping.get(height));
            }
            
            list.add(subList);
        }
        
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

        var list = verticalOrderTraversal(head);
        for(var e: list) {
            for (var ele: e) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

//    public static List<List<Integer>> verticalOrderTraversalOfBinaryTree(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        if(root == null) return list;
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        Map<Integer, List<Integer>> map = new TreeMap<>();
//        Map<TreeNode, Integer> level = new HashMap<>();
//
//        queue.add(root);
//        map.put(0, List.of(root.val));
//        level.put(root, 0);
//
//        while (!queue.isEmpty()) {
//            var top = queue.poll();
//            var currentLevel = level.get(top);
//
//            if(top.left != null) {
//                List<Integer> levelList = new ArrayList<>();
//
//                if(map.containsKey(currentLevel-1)) {
//                    levelList.addAll(map.get(currentLevel-1));
//                    levelList.add(top.left.val);
//                    map.put(currentLevel-1, levelList);
//                }
//                else {
//                    levelList.add(top.left.val);
//                    map.put(currentLevel-1, levelList);
//                }
//
//                level.put(top.left, currentLevel-1);
//                queue.add(top.left);
//            }
//
//            if(top.right != null) {
//                List<Integer> levelList = new ArrayList<>();
//
//                if(map.containsKey(currentLevel+1)) {
//                    levelList.addAll(map.get(currentLevel+1));
//                    levelList.add(top.right.val);
//                    map.put(currentLevel+1, levelList);
//                }
//                else {
//                    levelList.add(top.right.val);
//                    map.put(currentLevel+1, levelList);
//                }
//
//                level.put(top.right, currentLevel+1);
//                queue.add(top.right);
//            }
//        }
//
//        for(var l: map.values()) {
//            List<Integer> sortedList = new ArrayList<>(l);
//            Collections.sort(sortedList);
//            list.add(sortedList);
//        }
//
//        return list;
//    }
}
