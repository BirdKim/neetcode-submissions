class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // use the alphabet way since it only uses array size of 26 for each str
        Map<String, List<String>> res = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int[] alph = new int[26];
            char[] letters = strs[i].toCharArray();
            for (int j = 0; j < letters.length; j++) {
                alph[letters[j] - 'a']++;
            }
            String key = Arrays.toString(alph);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(strs[i]);
        }
        return new ArrayList<>(res.values());
    }
}
