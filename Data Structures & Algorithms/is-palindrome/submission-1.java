class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder combined = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (alphaNum(c))
                combined.append(Character.toLowerCase(c));
        }
        for (int l = 0; l < combined.length(); l++) {
            int r = combined.length()-1-l;
            if (combined.charAt(l) != combined.charAt(r))
                return false;
        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
