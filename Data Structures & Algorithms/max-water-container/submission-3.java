class Solution {
    public int maxArea(int[] heights) {
        // Using two pointers, l and r, while l is less than r, 
        // find the min height out of l and r and calculate the area of the water
        // if the new area is larger than the previously stored area, replace the stored data
        // then move the shorter bar inwards to find if there are bars closer together that
        // result in bigger area.
        int water = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int temp = (r - l) * Math.min(heights[l], heights[r]);
            water = Math.max(water, temp);
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return water;
    }
}
