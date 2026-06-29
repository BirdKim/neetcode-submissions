class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 > 0) return false;
        Stack<Character> openBracket = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        for (char c : s.toCharArray()) {
            // if I put (pair.containsKey(c)) I dont need extra conditionals after the for loop
            if (pair.containsKey(c)) {
                if (openBracket.isEmpty() || openBracket.peek().equals(c) || pair.get(c) != openBracket.pop())
                    return false;
                // if (pair.get(c) != openBracket.pop())
                //     return false;
            } else {
                openBracket.push(c);
            }
        }
        // this is redundant
        if (!openBracket.isEmpty()) return false;
        return true;
    }
}
