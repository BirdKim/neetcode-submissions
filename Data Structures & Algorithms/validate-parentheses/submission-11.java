class Solution {
    public boolean isValid(String s) {
        if (s.length()%2 > 0) return false;
        Stack<Character> openBrackets = new Stack<>();
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put(']', '[');
        pair.put('}', '{');
        for (char c : s.toCharArray()) {
            // if I put (pair.containsKey(c)) I dont need extra conditionals after the for loop
            if (pair.containsKey(c)) {
                if (!openBrackets.isEmpty() && openBrackets.peek() == pair.get(c)) {
                    openBrackets.pop();
                } else {
                    return false;
                }
            } else {
                openBrackets.push(c);
            }
        }
        // this is redundant
        return openBrackets.isEmpty();
    }
}
