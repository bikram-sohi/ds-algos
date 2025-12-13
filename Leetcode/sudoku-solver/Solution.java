class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char num = '1'; num <= '9'; num++) {
                        if(isValid(board, i, j, num)) {
                            board[i][j] = num;
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean isValid(char[][] board, int i, int j, char num) {
        for (int k = 0; k < 9; k++) {
            if(board[i][k] == num || board[k][j] == num) return false;
        }
        int row = (i / 3) * 3;
        int col = (j / 3) * 3;
        for(int a = row; a < row + 3; a++) {
            for(int b = col; b < col + 3; b++) {
                if(board[a][b] == num) return false;
            }
        }
        return true;
    }
}
