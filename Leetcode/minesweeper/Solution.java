class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0], j = click[1];

        if(board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }

        helper(board, i, j);
        return board;
    }

    void helper(char[][] board, int i, int j) {
        if(i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != 'E') return;

        int val = 0;

        int[][] dirs = new int[][]{
                        {1,0}, {-1,0}, {0, 1}, {0, -1},
                        {1,1}, {-1,-1}, {1, -1}, {-1, 1}
                    };

        for(int[] d: dirs) {
            int nR = i + d[0];
            int nC = j + d[1];

            if(nR >= 0 && nC >=0 && nR < board.length && nC < board[0].length){
                if(board[nR][nC] == 'M')
                    val++;
            }
        }

        if(val == 0) {
            board[i][j] = 'B';
            for(int[] d: dirs){
                int nR = i + d[0];
                int nC = j + d[1];
                helper(board, nR, nC);
            }
            return;
        }
        board[i][j] = (char) (val + '0');
    }
}
