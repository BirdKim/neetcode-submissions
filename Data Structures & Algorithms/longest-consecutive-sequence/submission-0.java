class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int longest = 0;
        Set<Integer> seq = new HashSet<>();
        for (int n : nums) {
            seq.add(n);
        }

        for (int n : seq) {
            int length = 1;
            while (seq.contains(n+length)) {
                length++;
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }
}
