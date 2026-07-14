class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int need = freq.size(), have = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (freq.containsKey(c) && window.get(c).equals(freq.get(c))) {
                have++;
            }
            while (have == need) {
                c = s.charAt(l);
                if (r - l + 1 < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                window.put(c, window.get(c) - 1);
                if (freq.containsKey(c) && window.get(c) < freq.get(c)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
