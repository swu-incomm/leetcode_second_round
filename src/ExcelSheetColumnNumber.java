/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        if(s == null ||s.length() == 0) return ans;
        for(int i = 0; i<s.length();i++) {
            ans = ans * 26 + (s.charAt(i)-'A' + 1);
        }
        return ans;
    }
    public static void main(String [] args) {
        ExcelSheetColumnNumber excelSheetColumnNumber = new ExcelSheetColumnNumber();
        System.out.println(excelSheetColumnNumber.titleToNumber("ZY"));
    }
}
