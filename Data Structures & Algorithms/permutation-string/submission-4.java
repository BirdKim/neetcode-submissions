class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // get a count for all letters in the alphabet
        int[] arr = new int[26];
        int[] arr2 = new int[26];
        // create the solution reference for s1 and "initialize" the sliding window for s2
        for (int i = 0; i < s1.length(); i++) {
            arr[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        int match = 0;
        // check current window with s1 to see how much they match
        for (int i = 0; i < 26; i++) {
            if (arr[i] == arr2[i])
                match++;
        }
        int l = 0;
        // return true if two arrays match, if not keep updating the array and see if the two arrays
        // match while the sliding window moves.
        for (int r = s1.length(); r < s2.length(); r++) {
            if (match == 26) {
                return true;
            }

            arr2[s2.charAt(l) - 'a']--;
            if (arr[s2.charAt(l) - 'a'] == arr2[s2.charAt(l) - 'a']) {
                match++;
            } else if (arr[s2.charAt(l) - 'a'] - 1 == arr2[s2.charAt(l) - 'a']) {
                match--;
            }

            arr2[s2.charAt(r) - 'a']++;
            if (arr[s2.charAt(r) - 'a'] == arr2[s2.charAt(r) - 'a']) {
                match++;
            } else if (arr[s2.charAt(r) - 'a'] + 1 == arr2[s2.charAt(r) - 'a']) {
                match--;
            }
            l++;
        }
        return match == 26;
    }
}
