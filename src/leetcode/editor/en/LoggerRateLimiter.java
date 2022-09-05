// [359]
/**
 * Design a logger system that receives a stream of messages along with their
 * timestamps. Each unique message should only be printed at most every 10 seconds (i.e.
 * a message printed at timestamp t will prevent other identical messages from
 * being printed until timestamp t + 10).
 * <p>
 * All messages will come in chronological order. Several messages may arrive at
 * the same timestamp.
 * <p>
 * Implement the Logger class:
 * <p>
 * <p>
 * Logger() Initializes the logger object.
 * bool shouldPrintMessage(int timestamp, string message) Returns true if the
 * message should be printed in the given timestamp, otherwise returns false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input
 * ["Logger", "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage",
 * "shouldPrintMessage", "shouldPrintMessage", "shouldPrintMessage"]
 * [[], [1, "foo"], [2, "bar"], [3, "foo"], [8, "bar"], [10, "foo"], [11, "foo"]]
 * Output
 * [null, true, true, false, false, false, true]
 * <p>
 * Explanation
 * Logger logger = new Logger();
 * logger.shouldPrintMessage(1, "foo");  // return true, next allowed timestamp
 * for "foo" is 1 + 10 = 11
 * logger.shouldPrintMessage(2, "bar");  // return true, next allowed timestamp
 * for "bar" is 2 + 10 = 12
 * logger.shouldPrintMessage(3, "foo");  // 3 < 11, return false
 * logger.shouldPrintMessage(8, "bar");  // 8 < 12, return false
 * logger.shouldPrintMessage(10, "foo"); // 10 < 11, return false
 * logger.shouldPrintMessage(11, "foo"); // 11 >= 11, return true, next allowed
 * timestamp for "foo" is 11 + 10 = 21
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= timestamp <= 10⁹
 * Every timestamp will be passed in non-decreasing order (chronological order).
 * 1 <= message.length <= 30
 * At most 10⁴ calls will be made to shouldPrintMessage.
 * <p>
 * <p>
 * Related Topics Hash Table Design 👍 1396 👎 174
 */

package leetcode.editor.en;

import java.util.HashMap;

public class LoggerRateLimiter {
    public static void main(String[] args) {
        Logger solution = new LoggerRateLimiter().new Logger();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Logger {
        private HashMap<String, Integer> msgDict; //key:message, value:timestamp

        public Logger() {
            msgDict = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!this.msgDict.containsKey(message)) {
                this.msgDict.put(message, timestamp);
                return true;
            }
            Integer oldTimestamp = this.msgDict.get(message);
            if (timestamp - oldTimestamp >= 10) {
                this.msgDict.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
//leetcode submit region end(Prohibit modification and deletion)

}