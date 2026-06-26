class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prodAll = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0)
                zeroCount+=1;
            else
                prodAll = prodAll * num;
            
        }

        // if there is more than 1 zero, the other zero will make the prod 0
        if (zeroCount > 1) {
            return new int[nums.length];
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount > 0) {
                res[i] = (nums[i] == 0) ? prodAll : 0;
            } else {
                res[i] = prodAll / nums[i];
            }
        }
        
        return res;
    }
}  
