class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        String encoded =  "";
        for (String s : strs) {
            encoded+=s + '-';
        }
        return encoded;
    }

    public List<String> decode(String str) {
        // edge cases: if the encoded str is empty return empty list
        if (str.length() == 0) return new ArrayList<>();
        List<String> original = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-') {
                original.add(str.substring(i-count, i));
                count = 0;
            } else {
                count++;
            }
        }

        return original;
    }
}
