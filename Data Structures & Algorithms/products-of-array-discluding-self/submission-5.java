class Solution {
    public int[] productExceptSelf(int[] nums) {
        // create pref[] and suff[] that handles indexes before and after the curr index respectively
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        // there are no indexes before and after 0 and n-1
        pref[0] = 1;
        suff[n-1] = 1;

        // nums=[1,2,4,6]
        // pref=[1,1,2,8]
        // pref[0]=0; pref[1]=nums[0]*1; pref[2]=nums[0]*nums[1]; pref[3]=nums[0]*nums[1]*nums[2]
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i-1] * pref[i-1];
        }
        // suff=[48,24,6,1]
        // suff[0]=nums[3]*nums[2]*nums[1]; suff[1]=nums[3]*nums[2]; suff[2]=nums[3]*1; suff[3]=1
        for (int i = n-2; i >= 0; i--) {
            suff[i] = nums[i+1] * suff[i+1];
        }
        // multiplies pref[] and suff[] making it "ExceptSelf"
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }

        return res;
    }
}  
