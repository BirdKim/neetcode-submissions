class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder combined = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c))
                combined.append(Character.toLowerCase(c));
        }
        for (int l = 0; l < combined.length(); l++) {
            int r = combined.length()-1-l;
            if (combined.charAt(l) != combined.charAt(r))
                return false;
        }
        return true;
    }
}
