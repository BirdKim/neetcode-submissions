class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;
        int water = 0;
        while (l < r) {
            int temp = (r - l) * Math.min(heights[l], heights[r]);
            if (temp > water) water = temp;
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return water;
    }
}
