class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s);
        reverse(sb, 0, sb.length() - 1);
        trim(sb);
        int start = 0, end = 0;
        while(start < sb.length()) {
            while(sb.charAt(end) != ' ') {
                end++;
                if(end == sb.length()) break;
            }
            reverse(sb, start, end - 1);
            start = end;
            while(end < sb.length() && sb.charAt(end) == ' ') {
                end++;
            }
            while(end > start + 1) {
                sb.deleteCharAt(start);
                end--;
            }
            start = end;
        }
        return sb.toString();
    }

    void reverse(StringBuilder sb, int i, int j) {
        while(j > i) {
            char c = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, c);
            i++;
            j--;
        }
    }

    void trim(StringBuilder sb) {
        int i = 0;
        while(sb.charAt(i) == ' ') sb.deleteCharAt(i);
        i = sb.length() - 1;
        while(sb.charAt(i) == ' ') {
            sb.deleteCharAt(i);
            i--;
        }
    }
}
