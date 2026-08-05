// O(n) solution
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return 0;
        int index = nums.length / 2;
        while (index >= 0 && index < nums.length) {
            if (nums[index] == target) return index;
            // if current index is greater than the target and the next one is less than, return -1
            if (index - 1 > 0 && nums[index] > target && nums[index - 1] < target) return -1;
            if (index + 1 < nums.length && nums[index] < target && nums[index + 1] > target) return -1;
            if (nums[index] > target) index--;
            else if (nums[index] < target) index++;
        }
        return -1;
    }
}
