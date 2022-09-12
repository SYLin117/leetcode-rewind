// [1996]
//You are playing a game that contains multiple characters, and each of the 
//characters has two main properties: attack and defense. You are given a 2D integer 
//array properties where properties[i] = [attacki, defensei] represents the 
//properties of the iᵗʰ character in the game. 
//
// A character is said to be weak if any other character has both attack and 
//defense levels strictly greater than this character's attack and defense levels. 
//More formally, a character i is said to be weak if there exists another character 
//j where attackj > attacki and defensej > defensei. 
//
// Return the number of weak characters. 
//
// 
// Example 1: 
//
// 
//Input: properties = [[5,5],[6,3],[3,6]]
//Output: 0
//Explanation: No character has strictly greater attack and defense than the 
//other.
// 
//
// Example 2: 
//
// 
//Input: properties = [[2,2],[3,3]]
//Output: 1
//Explanation: The first character is weak because the second character has a 
//strictly greater attack and defense.
// 
//
// Example 3: 
//
// 
//Input: properties = [[1,5],[10,4],[4,3]]
//Output: 1
//Explanation: The third character is weak because the second character has a 
//strictly greater attack and defense.
// 
//
// 
// Constraints: 
//
// 
// 2 <= properties.length <= 10⁵ 
// properties[i].length == 2 
// 1 <= attacki, defensei <= 10⁵ 
// 
//
// Related Topics Array Stack Greedy Sorting Monotonic Stack 👍 2338 👎 81


package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

public class TheNumberOfWeakCharactersInTheGame {
    public static void main(String[] args) {
        Solution solution = new TheNumberOfWeakCharactersInTheGame().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            // Method 1 using Sort O(NlogN)
            // if attack is same, desc def, then asec attack
            // 相同attack的角色會以def為大優先排在前面
            Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? (b[1] - a[1]) : a[0] - b[0]);
            int weakCahracters = 0;
            int maxDefense = 0;
            for (int i = properties.length - 1; i >= 0; i--) {
                //出現<maxDef表示比目前出現過的def小 且 attack一定比較小(不會遇到相同attack的)
                if (properties[i][1] < maxDefense) {
                    weakCahracters++;
                }
                maxDefense = Math.max(maxDefense, properties[i][1]);
            }
            return weakCahracters;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}