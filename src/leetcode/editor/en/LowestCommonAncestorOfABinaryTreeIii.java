// [1650]
//Given two nodes of a binary tree p and q, return their lowest common ancestor 
//(LCA). 
//
// Each node will have a reference to its parent node. The definition for Node 
//is below: 
//
// 
//class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node parent;
//}
// 
//
// According to the definition of LCA on Wikipedia: "The lowest common ancestor 
//of two nodes p and q in a tree T is the lowest node that has both p and q as 
//descendants (where we allow a node to be a descendant of itself)." 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//Output: 3
//Explanation: The LCA of nodes 5 and 1 is 3.
// 
//
// Example 2: 
// 
// 
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//Output: 5
//Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant 
//of itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], p = 1, q = 2
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 10⁵]. 
// -10⁹ <= Node.val <= 10⁹ 
// All Node.val are unique. 
// p != q 
// p and q exist in the tree. 
// 
//
// Related Topics Hash Table Tree Binary Tree 👍 1051 👎 35


package leetcode.editor.en;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LowestCommonAncestorOfABinaryTreeIii {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTreeIii().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

    class Solution {
        class Node {
            public int val;
            public Node left;
            public Node right;
            public Node parent;
        }

        public Node lowestCommonAncestor(Node p, Node q) {
            Queue<Node> stack1 = new LinkedList<>();
            Queue<Node> stack2 = new LinkedList<>();
            Node dummy1 = p;
            Node dummy2 = q;
            while (p != null) {
                stack1.add(p);
                p = p.parent;
            }
            while (q != null) {
                stack2.add(q);
                q = q.parent;
            }
            while (stack1.size() > stack2.size()) {
                stack1.poll();
            }
            while (stack2.size() > stack1.size()) {
                stack2.poll();
            }
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                Node tmp1 = stack1.poll();
                Node tmp2 = stack2.poll();
                if (tmp1 == tmp2) {
                    return tmp1;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}