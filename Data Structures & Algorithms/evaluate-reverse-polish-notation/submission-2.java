class Solution {
    public int evalRPN(String[] tokens) {
        // You can use a stack to solve this question as it is in the Stack section.
        // Never doubt neetcode
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens) {
            // When comparing Strings with Strings cannot use == because it compares memory address
            // and not the actual values. Must use .equals to compare Strings
            if (s.equals("+")) {
                nums.push(nums.pop() + nums.pop());
            } else if (s.equals("-")) {
                int temp2 = nums.pop();
                int temp1 = nums.pop();
                nums.push(temp1 - temp2);
            } else if (s.equals("*")) {
                nums.push(nums.pop() * nums.pop());
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
