class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 > 0) return false;
        // stack to store open brackets
        Stack<Character> open = new Stack<>();
        // need a way to see if the current char is an open bracket for close bracket
        // use a Map?
        // if the current char is a close bracket, need a way to check if the peek of the stack
        // is a pair with the current char
        Map<Character, Character> pair = new HashMap<>();
        pair.put(')', '(');
        pair.put('}', '{');
        pair.put(']', '[');

        for (char c : s.toCharArray()) {
            if (pair.containsKey(c)) {
                if (!open.isEmpty() && open.peek() == pair.get(c)) {
                    open.pop();
                } else {
                    return false;
                }
            } else {
                open.push(c);
            }
        }
        return open.isEmpty();
    }
}
