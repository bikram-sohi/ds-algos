class Solution {
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        rec(new ArrayList<String>(), 0, n);
        return res;
    }

    void rec(List<String> place, int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(place));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkValidity(place, row, n, i)) {
                String rowString = ".".repeat(i) + "Q" + ".".repeat(n - i - 1);
                
                place.add(rowString);
                rec(place, row + 1, n);
                place.remove(place.size() - 1);
            }
        }
    }

    boolean checkValidity(List<String> place, int row, int n, int col) {
        for (int i = 1; i <= row; i++) {
            int prevRow = row - i;
            
            if (place.get(prevRow).charAt(col) == 'Q') return false;
            
            if (col - i >= 0 && place.get(prevRow).charAt(col - i) == 'Q') return false;
            
            if (col + i < n && place.get(prevRow).charAt(col + i) == 'Q') return false;
        }
        return true;
    }
}
