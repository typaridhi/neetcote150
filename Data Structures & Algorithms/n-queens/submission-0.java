

class Solution {
    List<List<String>> result = new ArrayList<>();
    Set<Integer> r = new HashSet<>();
    Set<Integer> d = new HashSet<>();
    Set<Integer> antid = new HashSet<>();
    

    public List<List<String>> solveNQueens(int n) {
      

        List<String> board = new ArrayList<>();
        solve(board, 0 , n);

        return result;
    }

    void solve(List<String> board, int row , int n) {
        if (row == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (r.contains(col) ||
                d.contains(row + col) ||
                antid.contains(row - col)) {
                continue;
            }

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';

            board.add(new String(chars));

            r.add(col);
            d.add(row + col);
            antid.add(row - col);

            solve(board, row + 1 , n);

            board.remove(board.size() - 1);
            r.remove(col);
            d.remove(row + col);
            antid.remove(row - col);
        }
    }
}
