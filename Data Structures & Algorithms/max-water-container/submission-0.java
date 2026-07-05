class Solution {
    public int maxArea(int[] heights) {
        int width = heights.length - 1;
        int l = 0;
        int r = width;
        int water = width * Math.min(heights[l], heights[r]);
        while (l < r) {
            int temp = width * Math.min(heights[l], heights[r]);
            if (temp > water) water = temp;
            if (heights[l] < heights[r]) l++;
            else r--;
            width--;
        }
        return water;
    }
}
