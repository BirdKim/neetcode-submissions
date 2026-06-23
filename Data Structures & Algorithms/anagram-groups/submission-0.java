class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // create new map to store results
        Map<String, List <String>> res = new HashMap<>();
        // for loop to sort strings in alph order and add to map
        for (int i = 0; i < strs.length; i++) {
            // change str to char, sort, char to str
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            // if sortedStr doesn't exist in res, create a new key value pair
            res.putIfAbsent(sortedStr, new ArrayList<>());
            // get the key value pair of sortedStr and add the str as a value
            res.get(sortedStr).add(strs[i]);
        }
        // return array list of the map created
        return new ArrayList<>(res.values());
    }
}
