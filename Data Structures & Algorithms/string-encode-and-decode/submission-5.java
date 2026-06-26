class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";
        StringBuilder encoded = new StringBuilder();
        for (String s : strs) {
            encoded.append(s).append('-');
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) return new ArrayList<>();
        List<String> original = new ArrayList<>();
        char[] c = str.toCharArray();
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
