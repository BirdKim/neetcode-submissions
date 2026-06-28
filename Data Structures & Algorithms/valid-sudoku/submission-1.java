class Solution {
    public boolean isValidSudoku(char[][] board) {
        // checks row
        for (int i = 0; i < board.length; i++) {
            // initialize isValid array or set, if contains multiple return false;
            Set<Character> count = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } if (count.contains(board[i][j])) {
                    return false;
                }
                count.add(board[i][j]);
            }
        }
        // checks column
        for (int i = 0; i < board.length; i++) {
            // initialize isValid array or set, if contains multiple return false;
            Set<Character> count = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                if (count.contains(board[j][i])) {
                    return false;
                }
                count.add(board[j][i]);
            }
        }
        //checks boxes
        for (int i = 0; i < board.length; i++) {
            Set<Character> count = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int row = (i / 3) * 3 + j;
                    int col = (i % 3) * 3 + k;
                    if (board[row][col] == '.') continue;
                    if (count.contains(board[row][col])) return false;
                    count.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
