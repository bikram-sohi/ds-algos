class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) return 0;

        StringBuilder sb = new StringBuilder();
        int maxLen = 0;

        for (int j = 0; j < s.length(); j++) {
            char current = s.charAt(j);

            int index = sb.indexOf(String.valueOf(current));

            if (index != -1) {
                sb.delete(0, index + 1);
            }

            sb.append(current);
            maxLen = Math.max(maxLen, sb.length());
        }

        return maxLen;
    }
}
