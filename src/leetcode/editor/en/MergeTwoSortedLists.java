// [21]
/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: list1 = [], list2 = []
 * Output: []
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * <p>
 * <p>
 * Related Topics Linked List Recursion 👍 14481 👎 1288
 */

package leetcode.editor.en;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1, list1);
            ListNode preCur = dummy;
            merge(preCur, list1, list2);
            return dummy.next;
        }

        private void merge(ListNode pre, ListNode list1, ListNode list2) {
            if (list1 == null && list2 != null) {
                pre.next = list2;
                return;
            }
            if (list1 != null && list2 == null) {
                pre.next = list1;
                return;
            }
            if (list1 == null && list2 == null) {
                pre.next = null;
                return;
            }
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
            merge(pre, list1, list2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}