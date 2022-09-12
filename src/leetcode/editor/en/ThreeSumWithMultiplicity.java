// [923]
//Given an integer array arr, and an integer target, return the number of 
//tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target. 
//
// As the answer can be very large, return it modulo 10⁹ + 7. 
//
// 
// Example 1: 
//
// 
//Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//Output: 20
//Explanation: 
//Enumerating by the values (arr[i], arr[j], arr[k]):
//(1, 2, 5) occurs 8 times;
//(1, 3, 4) occurs 8 times;
//(2, 2, 4) occurs 2 times;
//(2, 3, 3) occurs 2 times.
// 
//
// Example 2: 
//
// 
//Input: arr = [1,1,2,2,2,2], target = 5
//Output: 12
//Explanation: 
//arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
//We choose one 1 from [1,1] in 2 ways,
//and two 2s from [2,2,2,2] in 6 ways.
// 
//
// Example 3: 
//
// 
//Input: arr = [2,1,3], target = 6
//Output: 1
//Explanation: (1, 2, 3) occured one time in the array so we return 1.
// 
//
// 
// Constraints: 
//
// 
// 3 <= arr.length <= 3000 
// 0 <= arr[i] <= 100 
// 0 <= target <= 300 
// 
//
// Related Topics Array Hash Table Two Pointers Sorting Counting 👍 2362 👎 280


package leetcode.editor.en;

import java.util.Arrays;

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        Solution solution = new ThreeSumWithMultiplicity().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int threeSumMulti(int[] arr, int target) {
            int MOD = 1_000_000_007;
            long ans = 0;
            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                int T = target - arr[i]; // remain target
                int j = i + 1, k = arr.length - 1;

                while (j < k) { // two pointer technique
                    if (arr[j] + arr[k] < T) {
                        j++;
                    } else if (arr[j] + arr[k] > T) {
                        k--;
                    } else if (arr[j] != arr[k]) { //arr[j]+arr[k]的第一種情況
                        int left = 1, right = 1;//左右計數
                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            left++;
                            j++;
                        }
                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            right++;
                            k--;
                        }
                        ans += (long) left * right;
                        ans %= MOD;
                        j++;
                        k--;
                    } else { // arr[j] = arr[k], 若有M個數則共有(M,C,2)(M取2)
                        ans += (long) (k - j + 1) * (k - j) / 2;
                        ans %= MOD;
                        break;
                    }
                }
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}