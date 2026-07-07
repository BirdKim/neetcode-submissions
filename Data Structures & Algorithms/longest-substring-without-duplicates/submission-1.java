class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> dups = new HashSet<>();
        int res = 0, count = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (dups.contains(s.charAt(r))) {
                dups.remove(s.charAt(l));
                l++;
                count--;
            }
            dups.add(s.charAt(r));
            count++;
            res = Math.max(res, count);
        }
        return res;
    }
}
