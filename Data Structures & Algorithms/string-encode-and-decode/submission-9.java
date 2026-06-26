class Solution {

    public String encode(List<String> strs) {
            StringBuilder encoded =  new StringBuilder();
            for (String s : strs) {
                encoded.append(s.length()).append('#').append(s);
            }
        // in the form of 3#num4#four...
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> text = new ArrayList();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            // get the number, get past # and get substring of length number
            // str.charAt[i] is the number
            while (str.charAt(j) != '#') {
                j++;
            }
            // gets the number
            int size = Integer.parseInt(str.substring(i, j));
            // get past the #
            i = j + 1;
            j = i + size;
            text.add(str.substring(i, j));
            i = j;
        }
        return text;
    }
}
