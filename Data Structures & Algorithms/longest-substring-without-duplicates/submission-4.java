class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> sub = new HashSet<>();
        int count = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (sub.contains(s.charAt(r))) {
                sub.remove(s.charAt(l));
                l++;
            }
            sub.add(s.charAt(r));
            count = Math.max(count, r - l + 1);
        }
        return count;
    }
}
