class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack takes in variables int[]
        // original thought process was right but just needed to know Stack<int[]> is valid
        // Dont forget that input types into Set, Stack and other heaps can also be arrays
        
        // initialize results array equal to the length of temperatures
        int[] results = new int[temperatures.length];
        // initialize stack that stores array types where the array is formed of temp and index
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            // while the stack is not empty and the current stacks peek is less than the 
            // current temp at the index, pop the stack and put the result of 
            // current index minus the index the peek was stored as it in results
            // this repeats as long as the temp is greater than the top value in stack
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] pair = stack.pop();
                results[pair[1]] = i - pair[1];
            }
            // once the stack is empty or if the top value in stack is greater than temp at index i,
            // push the temp and index to stack
            stack.push(new int[]{temp, i});
        }
        return results;
    }
}
