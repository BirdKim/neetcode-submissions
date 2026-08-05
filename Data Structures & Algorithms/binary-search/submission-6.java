// Binary search needs to be so that it cuts down half of the size every iteration
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        // get the mid value of l and r
        while (l <= r) {
            // mid value
            int m = l + (r - l) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
}
