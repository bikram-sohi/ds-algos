class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        fill(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    void fill(int[][] image, int sr, int sc, int color, int orig) {
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != orig) {
            return;
        }
        if(image[sr][sc] == orig) {
            image[sr][sc] = color;
        }
        fill(image, sr + 1, sc, color, orig);
        fill(image, sr - 1, sc, color, orig);
        fill(image, sr, sc + 1, color, orig);
        fill(image, sr, sc - 1, color, orig);
        return;
    }
}
