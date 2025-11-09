class Solution {
    int left = 0, right = 0;
    public String longestPalindrome(String s) {
        for(int i = 0; i < s.length(); i++) {
            int l = i - 1, r = i + 1;
            checkPali(l, r, s);
            l = i - 1;
            r = i;
            checkPali(l, r, s);
        }
        return s.substring(left, right + 1);
    }

    void checkPali(int l, int r, String s) {
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if(r - l > right - left) {
                left = l;
                right = r;
            }
            r++;
            l--;
        }
    }
}
