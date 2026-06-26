class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prodAll = 1;
        for (int num : nums) {
            prodAll = prodAll * num;
        }

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod = prod * nums[j];
                }
            }
            res[i] = prod;
        }
        return res;
    }
}  
