// [811]
//A website domain "discuss.leetcode.com" consists of various subdomains. At 
//the top level, we have "com", at the next level, we have "leetcode.com" and at the 
//lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.
//leetcode.com", we will also visit the parent domains "leetcode.com" and "com" 
//implicitly. 
//
// A count-paired domain is a domain that has one of the two formats "rep d1.d2.
//d3" or "rep d1.d2" where rep is the number of visits to the domain and d1.d2.d3 
//is the domain itself. 
//
// 
// For example, "9001 discuss.leetcode.com" is a count-paired domain that 
//indicates that discuss.leetcode.com was visited 9001 times. 
// 
//
// Given an array of count-paired domains cpdomains, return an array of the 
//count-paired domains of each subdomain in the input. You may return the answer in 
//any order. 
//
// 
// Example 1: 
//
// 
//Input: cpdomains = ["9001 discuss.leetcode.com"]
//Output: ["9001 leetcode.com","9001 discuss.leetcode.com","9001 com"]
//Explanation: We only have one website domain: "discuss.leetcode.com".
//As discussed above, the subdomain "leetcode.com" and "com" will also be 
//visited. So they will all be visited 9001 times.
// 
//
// Example 2: 
//
// 
//Input: cpdomains = ["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com",
// "5 wiki.org"]
//Output: ["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 
//org","1 intel.mail.com","951 com"]
//Explanation: We will visit "google.mail.com" 900 times, "yahoo.com" 50 times, 
//"intel.mail.com" once and "wiki.org" 5 times.
//For the subdomains, we will visit "mail.com" 900 + 1 = 901 times, "com" 900 + 
//50 + 1 = 951 times, and "org" 5 times.
// 
//
// 
// Constraints: 
//
// 
// 1 <= cpdomain.length <= 100 
// 1 <= cpdomain[i].length <= 100 
// cpdomain[i] follows either the "repi d1i.d2i.d3i" format or the "repi d1i.d2
//i" format. 
// repi is an integer in the range [1, 10⁴]. 
// d1i, d2i, and d3i consist of lowercase English letters. 
// 
//
// Related Topics Array Hash Table String Counting 👍 1227 👎 1185


package leetcode.editor.en;

import java.util.*;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        Solution solution = new SubdomainVisitCount().new Solution();
        System.out.println(solution.subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> result = new HashMap();
            for (int i = 0; i < cpdomains.length; i++) {
                String domains = cpdomains[i];
                String[] info = domains.split(" ");
                String[] subDomains = info[1].split("\\.");
                for (int j = 0; j < subDomains.length; j++) {
                    String subDomain = String.join(".", Arrays.copyOfRange(subDomains, j, subDomains.length));
                    result.put(subDomain, result.getOrDefault(subDomain, 0) + Integer.valueOf(info[0]));
                }
            }
            List<String> list = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                list.add(entry.getValue() + " " + entry.getKey());
            }
            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}