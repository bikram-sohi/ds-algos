class TrieNode {
    public HashMap<Character, TrieNode> wordMap = new HashMap<>();
    public String eow = null;

    public void addWord(String word) {
        TrieNode curr = this;
        for (char ch : word.toCharArray()) {
            if (!curr.wordMap.containsKey(ch)) {
                curr.wordMap.put(ch, new TrieNode());
            }
            curr = curr.wordMap.get(ch);
        }
        curr.eow = word;
    }
}

class Solution {
    char[][] board;
    int rows;
    int cols;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    List<String> out = new ArrayList<>();

    public void dfs(int r, int c, TrieNode trie) {
        if (trie.eow != null) {
            out.add(trie.eow);
            trie.eow = null;
        }
        char letter = board[r][c];
        board[r][c] = '-';
        for (int[] direction : directions) {
            int r2 = direction[0];
            int c2 = direction[1];
            int newR = r + r2;
            int newC = c + c2;
            if (0 <= newR && newR < rows && 0 <= newC && newC < cols && board[newR][newC] != '-' && trie.wordMap.containsKey(board[newR][newC])) {
                TrieNode t = trie.wordMap.get(board[newR][newC]);
                dfs(newR, newC, t);
                if (t.wordMap.isEmpty()) {
                    trie.wordMap.remove(board[newR][newC]);
                }
            }
        }
        board[r][c] = letter;
    }

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;

        TrieNode trie = new TrieNode();

        for (String word : words) {
            trie.addWord(word);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (trie.wordMap.containsKey(board[r][c])) {
                    dfs(r, c, trie.wordMap.get(board[r][c]));
                }
            }
        }

        return out;
    }
}
