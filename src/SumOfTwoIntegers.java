/**
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
 这道题的解法思路为 不断地将两个加数通过异或和与以及左移位的方式转为为同等的另外两个加数 最后当一方（carry）为零时 另一个数就是结果
**/


public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        while(b != 0) {
            int sum = a ^ b;
            int carry = (a & b) <<1;
            b = carry;
            a = sum;
        }
        return a;
    }
}
