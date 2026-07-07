class Solution {
    public int trap(int[] height) {
        int water = 0;
        int l = 0, r = height.length - 1;
        int maxl = height[l], maxr = height[r];
        while (l < r) {
            if (maxl < maxr) {
                l++;
                maxl = Math.max(maxl, height[l]);
                water += maxl - height[l];
            } else {
                r--;
                maxr = Math.max(maxr, height[r]);
                water += maxr - height[r];
            }
        }
        return water;
    }
}
