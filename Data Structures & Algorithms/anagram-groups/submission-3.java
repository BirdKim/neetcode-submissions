class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use the alphabet way since it only uses array size of 26 for each str
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] alph = new int[26];
            for (char c : s.toCharArray()) {
                alph[c - 'a']++;
            }
            String key = Arrays.toString(alph);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
