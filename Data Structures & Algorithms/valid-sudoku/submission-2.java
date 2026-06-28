// Given solution
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // checks row
        for (int row = 0; row < board.length; row++) {
            // initialize isValid array or set, if contains multiple return false;
            Set<Character> count = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] == '.') continue;
                if (count.contains(board[row][i])) return false;
                count.add(board[row][i]);
            }
        }
        // checks column
        for (int col = 0; col < board.length; col++) {
            // initialize isValid array or set, if contains multiple return false;
            Set<Character> count = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] == '.') continue;
                if (count.contains(board[i][col])) return false;
                count.add(board[i][col]);
            }
        }
        //checks boxes
        for (int square = 0; square < board.length; square++) {
            Set<Character> count = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (count.contains(board[row][col])) return false;
                    count.add(board[row][col]);
                }
            }
        }

        return true;
    }
}
