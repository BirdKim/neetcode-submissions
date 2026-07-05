/*  Two pointers where you set a starting point and then go through the rest of the 
    array with two pointers  */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int trips = nums[i] + nums[l] + nums[r];
                if (trips > 0) r--;
                else if (trips < 0) l++;
                else if (trips == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]) l++;
                }
            }
        }
        return res;
    }
}
