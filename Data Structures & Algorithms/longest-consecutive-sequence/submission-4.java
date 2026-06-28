class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = 0;
        Set<Integer> seq = new HashSet<>();
        // by adding all elements in nums to a set, it removes all duplicate elements
        for (int n : nums) {
            seq.add(n);
        }

        for (int n : seq) {
            // reduces redundency. checks if n is not the start of a sequence
            if (!seq.contains(n - 1)) {
                int length = 1;
                // while there is an element that continues the consecutive sequence increase length by 1
                while (seq.contains(n + length)) {
                    length++;
                }
                // see whether the new sequence found is greater than the longest previous sequence
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}
