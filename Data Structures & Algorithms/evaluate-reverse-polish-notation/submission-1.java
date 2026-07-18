class Solution {
    public int evalRPN(String[] tokens) {
        // You can use a stack to solve this question as it is in the Stack section.
        // Never doubt neetcode
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                int temp2 = nums.pop();
                int temp1 = nums.pop();
                nums.push(temp1 + temp2);
            } else if (s.equals("-")) {
                int temp2 = nums.pop();
                int temp1 = nums.pop();
                nums.push(temp1 - temp2);
            } else if (s.equals("*")) {
                int temp2 = nums.pop();
                int temp1 = nums.pop();
                nums.push(temp1 * temp2);
            } else if (s.equals("/")) {
                int temp2 = nums.pop();
                int temp1 = nums.pop();
                nums.push(temp1 / temp2);
            } else {
                nums.push(Integer.parseInt(s));
            }
        }
        return nums.pop();
    }
}
