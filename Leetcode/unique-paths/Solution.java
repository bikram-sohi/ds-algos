class Solution {
    public int uniquePaths(int m, int n) {
        int[] top = new int[m];
        int[] bottom = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    bottom[j] = 1;
                    continue;
                }
                if (j == 0) {
                    bottom[j] = 1;
                    continue;
                }
                bottom[j] = top[j] + bottom[j - 1];
            }
            int[] temp = top;
            top = bottom;
            bottom = temp;
        }
        return top[m - 1];
    }
}
