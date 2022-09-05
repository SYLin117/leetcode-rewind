// [234]
/**
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: head = [1,2]
 * Output: false
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in the list is in the range [1, 10⁵].
 * 0 <= Node.val <= 9
 * <p>
 * <p>
 * <p>
 * Follow up: Could you do it in
 * O(n) time and
 * O(1) space?
 * <p>
 * Related Topics Linked List Two Pointers Stack Recursion 👍 11449 👎 643
 */

package leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(0);
        System.out.println(solution.isPalindrome(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public boolean isPalindrome(ListNode head) {
//            // brute force
//            int cnt = 0;
//            ListNode dummy = new ListNode(0, head);
//            while (head != null) {
//                cnt++;
//                head = head.next;
//            }
//            if (cnt <= 1) return true;
//
//            int mid = 0;
//            if (cnt % 2 == 0) mid = cnt / 2;
//            else mid = cnt / 2 + 1;
//
//            Stack<Integer> stack = new Stack<>();
//            int idx = 1;
//            head = dummy.next;
//            while (head != null) {
//                int value = head.val;
//                if (idx <= mid) {
//                    if (!(cnt % 2 != 0 && idx == mid))
//                        stack.push(value);
//                } else {
//                    if (stack.pop() != value) return false;
//                }
//                head = head.next;
//                idx++;
//            }
//            return true;

            // two pointer
            ListNode slow = head;
            ListNode fast = head;
            Stack<Integer> stack = new Stack<>();
            while (fast != null) {
                fast = fast.next;
                if (fast != null) {
                    fast = fast.next;
                    stack.push(slow.val);
                }
                slow = slow.next;

            }
            while (slow != null) {
                if (stack.pop() != slow.val) return false;
                slow = slow.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}