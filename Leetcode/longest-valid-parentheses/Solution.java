class Solution {
    public int longestValidParentheses(String s) {
        int opening = 0;
        int closing = 0;

        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                opening++;
            }
            else {
                closing++;
            }

            if(closing > opening) {
                opening = closing = 0;
            }
            else if(opening == closing) {
                max = Math.max(opening + closing, max);
            }
        }

        opening = 0;
        closing = 0;

        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '(') {
                opening++;
            }
            else {
                closing++;
            }

            if(opening > closing) {
                opening = closing = 0;
            }
            else if(opening == closing) {
                max = Math.max(opening + closing, max);
            }
        }
        
        return max;
    }
}
