// [346]
//Given a stream of integers and a window size, calculate the moving average of 
//all integers in the sliding window. 
//
// Implement the MovingAverage class: 
//
// 
// MovingAverage(int size) Initializes the object with the size of the window 
//size. 
// double next(int val) Returns the moving average of the last size values of 
//the stream. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//Output
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//Explanation
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // return 1.0 = 1 / 1
//movingAverage.next(10); // return 5.5 = (1 + 10) / 2
//movingAverage.next(3); // return 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // return 6.0 = (10 + 3 + 5) / 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= size <= 1000 
// -10⁵ <= val <= 10⁵ 
// At most 10⁴ calls will be made to next. 
// 
//
// Related Topics Array Design Queue Data Stream 👍 1387 👎 134


package leetcode.editor.en;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
    public static void main(String[] args) throws Exception {
        MovingAverage solution = new MovingAverageFromDataStream().new MovingAverage(3);
        System.out.println(solution.next(1));
        System.out.println(solution.next(10));
        System.out.println(solution.next(3));
        System.out.println(solution.next(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        Queue<Integer> queue;
        int size = 0;
        int sum = 0;
        int lastValue = 0;
        double cnt = 0;

        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            this.cnt++;
            this.sum += val;
            queue.add(val);
            if (this.cnt > this.size) {
                this.sum -= queue.remove();
                this.cnt--;
            }
            return (double) (sum / cnt);
//            return this.queue.stream().mapToInt(x -> x).average().orElse(0);
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}