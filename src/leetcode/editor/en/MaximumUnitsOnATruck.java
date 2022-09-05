// [1710]
//You are assigned to put some amount of boxes onto one truck. You are given a 2
//D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]: 
//
// 
// numberOfBoxesi is the number of boxes of type i. 
// numberOfUnitsPerBoxi is the number of units in each box of the type i. 
// 
//
// You are also given an integer truckSize, which is the maximum number of 
//boxes that can be put on the truck. You can choose any boxes to put on the truck as 
//long as the number of boxes does not exceed truckSize. 
//
// Return the maximum total number of units that can be put on the truck. 
//
// 
// Example 1: 
//
// 
//Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
//Output: 8
//Explanation: There are:
//- 1 box of the first type that contains 3 units.
//- 2 boxes of the second type that contain 2 units each.
//- 3 boxes of the third type that contain 1 unit each.
//You can take all the boxes of the first and second types, and one box of the 
//third type.
//The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
// 
//
// Example 2: 
//
// 
//Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//Output: 91
// 
//
// 
// Constraints: 
//
// 
// 1 <= boxTypes.length <= 1000 
// 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000 
// 1 <= truckSize <= 10⁶ 
// 
//
// Related Topics Array Greedy Sorting 👍 3033 👎 169


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumUnitsOnATruck {
    public static void main(String[] args) {
        Solution solution = new MaximumUnitsOnATruck().new Solution();
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        System.out.println(solution.maximumUnits(boxTypes, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumUnits(int[][] boxTypes, int truckSize) {
            // Sort O(nlogn)
//            Arrays.sort(boxTypes, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return Integer.compare(o2[1], o1[1]);
//                }
//            });
//
//            int boxCnt = 0;
//            int unitCnt = 0;
//            for (int i = 0; i < boxTypes.length; i++) {
//                int cnt = 0;
//                while (boxCnt < truckSize && cnt < boxTypes[i][0]) {
//                    boxCnt++;
//                    unitCnt += boxTypes[i][1];
//                    cnt++;
//                }
//                if (boxCnt > truckSize) {
//                    boxCnt--;
//                    unitCnt -= boxTypes[i][1];
//                    break;
//                }
//            }
//            return unitCnt;

            // Heap (logN)
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
            queue.addAll(Arrays.asList(boxTypes));
            int unitCount = 0;
            while (!queue.isEmpty()) {
                int[] top = queue.poll();
                int boxCount = Math.min(truckSize, top[0]); // truckSize為剩餘的容量，取兩者最小確保不會超過
                unitCount += boxCount * top[1];
                truckSize -= boxCount;
                if (truckSize == 0)
                    break;
            }
            return unitCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}