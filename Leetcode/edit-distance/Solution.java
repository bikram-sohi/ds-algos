class Solution {
    public int minDistance(String word1, String word2) {
        String shorter = "";
        String longer = "";
        if (word1.length() > word2.length()) {
            shorter = word2;
            longer = word1;
        } else {
            shorter = word1;
            longer = word2;
        }
        int[] top = new int[shorter.length() + 1];
        int[] bottom = new int[shorter.length() + 1];
        for(int r = 0; r <= longer.length(); r++) {
            for (int c = 0; c <= shorter.length(); c++) {
                if (r  == 0) {
                    top[c] = c;
                    continue;
                }
                if (c == 0) {
                    bottom[c] = r;
                    continue;
                }
                if(longer.charAt(r - 1) == shorter.charAt(c - 1)) {
                    bottom[c] = top[c - 1];
                }
                else {
                    bottom[c] = 1 + Math.min(top[c], Math.min(top[c - 1], bottom[c - 1]));
                }
            }
            if (r > 0) {
                int[] temp = top;
                top = bottom;
                bottom = temp;
            }
        }
        return top[shorter.length()];
    }
}
