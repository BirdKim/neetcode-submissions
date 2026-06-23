class Solution {
    public boolean isAnagram(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        if (schar.length != tchar.length) return false;
        Arrays.sort(schar);
        Arrays.sort(tchar);
        
        for (int i = 0; i < schar.length; i++) {
            if (schar[i] != tchar[i]){
                return false;
            }
        }
        return true;
    }
}
