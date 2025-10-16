class Solution {
    public int firstUniqChar(String s) {
        int[] frequencyCount = new int[26];
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            frequencyCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < stringLength; i++) {
            if (frequencyCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
