class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder combined = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                combined.append(Character.toLowerCase(c));
            }
        }
        return combined.toString().equals(combined.reverse().toString());
    }
}
