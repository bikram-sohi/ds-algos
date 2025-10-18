class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] chars = s.toCharArray();
        long sum = 0;
        for(int i = shifts.length - 1; i >= 0; i--) {
            sum += shifts[i];
            chars[i] = (char) ('a' + (chars[i] - 'a' + sum) % 26);
        }
        return new String(chars);
    }
}
