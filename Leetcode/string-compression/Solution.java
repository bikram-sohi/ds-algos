class Solution {
    public int compress(char[] chars) {
        int ans = 0;
        for(int i = 0; i < chars.length;) {
            char cur = chars[i];
            int count = 0;

            while(i < chars.length && cur == chars[i]) {
                i++;
                count++;
            }

            chars[ans++] = cur;

            if(count > 1) {
                for(char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }
}
