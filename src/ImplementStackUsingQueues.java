/**
 * Implement a last in first out (LIFO) stack using only two queues. The implemented stack should support all
 * the functions of a normal queue (push, top, pop, and empty).
 *
 * Implement the MyStack class:
 *
 * void push(int x) Pushes element x to the top of the stack.
 * int pop() Removes the element on the top of the stack and returns it.
 * int top() Returns the element on the top of the stack.
 * boolean empty() Returns true if the stack is empty, false otherwise.
 * Notes:
 *
 * You must use only standard operations of a queue, which means only push to back, peek/pop from front, size, and
 * is empty operations are valid.
 * Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque
 * (double-ended queue), as long as you use only a queue's standard operations.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 2, 2, false]
 *
 * Explanation
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // return 2
 * myStack.pop(); // return 2
 * myStack.empty(); // return False
 *
 *
 * Constraints:
 *
 * 1 <= x <= 9
 * At most 100 calls will be made to push, pop, top, and empty.
 * All the calls to pop and top are valid.
 */
import java.util.*;
public class ImplementStackUsingQueues {
     class MyStack {
        private Queue <Integer> q1;
        private Queue <Integer> q2;
        int top;
        /** Initialize your data structure here. */
        public MyStack() {
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            q1.offer(x);
            this.top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            while(this.q1.size() > 1) {
                top = q1.remove();
                int temp = q1.poll();
                q2.offer(temp);
            }
            int res = q1.poll();
            q1 = q2;
            q2 = new LinkedList<>();
            return res;
        }

        /** Get the top element. */
        public int top() {
            return this.top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return this.q1.isEmpty();
        }
    }
}
