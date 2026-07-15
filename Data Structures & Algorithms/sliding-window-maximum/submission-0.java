class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int resIdx = 0;
        for (int r = 0; r < nums.length; r++) {
            int[] value = {nums[r], r};
            max.add(value);
            if (r >= k - 1) {
                while (r - k  >= max.peek()[1]) {
                    max.remove();
                }
                res[resIdx++] = max.peek()[0];
            }
        }
        return res;
    }
}
