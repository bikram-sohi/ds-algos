class Solution {
    public int minCut(String s) {
        int len = s.length();
        Boolean[][] palindromes = new Boolean[len][len];
        for(int i = 0; i < len; i++) {
            palindromes[i][i] = true;
        }
        for(int l = 2; l < len + 1; l++) {
            for(int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;
                if(l == 2) {
                    palindromes[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    palindromes[i][j] = s.charAt(i) == s.charAt(j) && palindromes[i + 1][j - 1];
                }
            }
        }
        int[] cuts = new int[len];
        for(int i = 0; i < len; i++) {
            cuts[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < len; i++) {
            if(palindromes[0][i]) {
                cuts[i] = 0;
            }
            else {
                cuts[i] = cuts[i - 1] + 1;
                for(int j = 1; j < i; j++) {
                    if(palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
                        cuts[i] = cuts[j - 1] + 1;
                    }
                }
            }
        }
        return cuts[len - 1];
    }
}
