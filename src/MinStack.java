import java.util.Stack;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */

//solution1 : for each incomming min value, if it is less than our current min value
//We will store the previous min value right below next to it, in this way whenever we pop out the node which is the
//current min value, we will need to update the new current min value by poping twice(one for real poping and one for get the prev min min value)
//two stack solution will maintain another minStack to track all the min Val comming in
public class MinStack {
    private Stack<Integer> stack;
    int minVal;
    public MinStack() {
        this.stack = new Stack<>();
        minVal = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //if the incomming value is less than the min value, we will need to place the prev min val in the second place just in case the next operation is peek
        //**this equal sign is super important , because we may push the sme minVal again later on, still need to update the second minVal as the current minval
        if(x <= minVal) {stack.push(minVal);minVal = x;}
        this.stack.push(x);
    }

    public void pop() {
        if(stack.peek() == minVal) {
            //we need to pop twice
            stack.pop();
            this.minVal = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return this.minVal;
    }

    public static void main(String [] args) {
        MinStack minStack = new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.top());
//        System.out.println(minStack.getMin());
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */