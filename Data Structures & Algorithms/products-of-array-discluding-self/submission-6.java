class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];    // prod of numbers before the index
        int[] suff = new int[n];    // prod of numbers after the index

        // initialize first and last value of pref and suff
        pref[0] = 1;
        suff[n-1] = 1;

        // update pref
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i-1] * pref[i-1];
        }
        // update suff
        for (int i = n-2; i >= 0; i--) {
            suff[i] = nums[i+1] * suff[i+1];
        }
        // combine pref and suff
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}  
