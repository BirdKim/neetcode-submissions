class Solution {
    public int trap(int[] height) {
        // initialize two pointer, l and r, and two variables, lMax and rMax
        // while l is less than r, if lMax is lower than rMax, then move l inwards,
        // find larger value between element at l and lMax, add the difference between lMax and l to water
        // do the same if rMax is lower than lMax
        // return water
        int water = 0;
        int l = 0, r = height.length - 1;
        int lMax = height[l], rMax = height[r];
        while (l < r) {
            if (lMax < rMax) {
                l++;
                lMax = Math.max(height[l], lMax);
                water += lMax - height[l];
            } else {
                r--;
                rMax = Math.max(height[r], rMax);
                water += rMax - height[r];
            }
        }
        return water;
    }
}
