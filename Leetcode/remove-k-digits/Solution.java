class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder s = new StringBuilder();
        for(char c : num.toCharArray()) {
            while(s.length() > 0 && k > 0 && s.charAt(s.length() - 1) > c) {
                s.deleteCharAt(s.length() - 1);
                k--;
            }
            s.append(c);
        }

        while (k > 0 && s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
            k--;
        }

        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }

        String str = s.substring(index);

        return str.length() > 0 ? str : "0";
    }
}
