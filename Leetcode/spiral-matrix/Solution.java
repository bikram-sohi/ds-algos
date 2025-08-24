import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = matrix[0].length;
        int top = 0;
        int bottom = matrix.length;
        while((left < right) && top < bottom) {
            for (int col = left; col < right; col++) {
                result.add(matrix[top][col]);
            }
            for (int row = top + 1; row < bottom; row++) {
                result.add(matrix[row][right - 1]);
            }
            for (int col = right - 2; col >= left; col--) {
                if (top == bottom - 1) break;
                result.add(matrix[bottom - 1][col]);
            }
            for (int row = bottom - 2; row > top; row--) {
                if (left == right - 1) break;
                result.add(matrix[row][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }
}
