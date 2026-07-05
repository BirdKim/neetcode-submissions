class Solution {
    public int trap(int[] height) {
        int water = 0;
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(lMax, height[l]);
                water += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(rMax, height[r]);
                water += rMax - height[r];
            }
        }
        return water;
    }
}
