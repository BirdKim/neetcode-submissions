class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 > 0) return false;
        Stack<Character> openBracket = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        for (char c : s.toCharArray()) {
            if (!pair.containsKey(c)) {
                openBracket.push(c);
            } else {
                if (openBracket.isEmpty() || openBracket.peek().equals(c))
                    return false;
                if (pair.get(c) != openBracket.pop())
                    return false;
            }
        }
        if (!openBracket.isEmpty()) return false;
        return true;
    }
}
