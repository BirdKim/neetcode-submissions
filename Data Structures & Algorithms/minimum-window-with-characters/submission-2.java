// I initially to initialize a Map variable but could think of how to compare the two strings but I just needed to use two maps
// resLen is initialized to infinity so that if there is a substring of s that contains all of t it sets it to that value
// if there is no change to resLen until the end of the code, return empty string.
// comparing makes sense, thought to do it like that from the start
class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.isEmpty()) return "";

        // Since they allow duplicates, Map is a better fit to count frequency than Set
        // if they didn't allow dups, Set wouldve been a better choice
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        // add all the char from t to freq
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        // initialize return value and counts needed
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int need = freq.size(), have = 0;
        int l = 0;
        // for the length of s
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            // input the char of s at r to a map named window
            window.put(c, window.getOrDefault(c, 0) + 1);
            // if freq contains char and the frequency count in both freq and window equal, increment have count by 1
            if (freq.containsKey(c) && window.get(c) == freq.get(c)) {
                have++;
            }
            // while the two counts are equal
            while (have == need) {
                c = s.charAt(l);
                // if the current substring is less than the stored shortest substring, update all variables
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                // remove the most left char in the substring
                window.put(c, window.get(c) - 1);
                // if the frequency count for char of s at r is less than the frequency count in t, decrement have count by 1
                if (freq.containsKey(c) && window.get(c) < freq.get(c)) {
                    have--;
                }
                // move the pointer to the right by one
                l++;
                // if removing the char resulted in the have count going down, it will exit the while loop
            }
        }
        // if resLen == infinity return "" if not return substring
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
