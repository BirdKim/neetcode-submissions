/*  Two pointers where you set a starting point and then go through the rest of the 
    array with two pointers  */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // initialize result List of Lists
        List<List<Integer>> res = new ArrayList<>();
        // sort array
        Arrays.sort(nums);
        // loop through the array
        for (int i = 0; i < nums.length; i++) {
            // check if the current number is positive, if so then all numbers from now
            // are positive so we terminate loop
            if (nums[i] > 0) break;
            // checks if the current element is a duplicate
            if (i > 0 && nums[i] == nums[i-1]) continue;
            // initialize two pointers
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int trips = nums[i] + nums[l] + nums[r];
                // move the two pointer accordingly depending on the outcome of the trips
                if (trips > 0) r--;
                else if (trips < 0) l++;
                else if (trips == 0) {
                    // if trips add to 0, 
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // if there are more trips after this the element pointed by the right pointer 
                    // needs to get smaller, so we move both inwards by one.
                    l++;
                    r--;
                    // iterate until we pass all the duplicate elements for the left pointer
                    while (l < r && nums[l] == nums[l-1]) l++;
                }
            }
        }
        return res;
    }
}
