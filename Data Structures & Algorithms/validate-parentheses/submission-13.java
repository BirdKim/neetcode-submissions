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

        for (int i = 0; i < s.length(); i++) {
            if (pair.containsKey(s.charAt(i))) {
                if (open.isEmpty()) return false;
                if (open.peek() == pair.get(s.charAt(i))) {
                    open.pop();
                } else {
                    return false;
                }
            } else {
                open.push(s.charAt(i));
            }
        }
        return open.isEmpty();
    }
}
