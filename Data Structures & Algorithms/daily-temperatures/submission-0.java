class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // Stack takes in variables int[]
        // original thought process was right but just needed to know Stack<int[]> is valid
        // Dont forget that input types into Set, Stack and other heaps can also be arrays
        int[] results = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < temp) {
                int[] pair = stack.pop();
                results[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{temp, i});
        }
        return results;
    }
}
