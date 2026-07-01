// Better solution according to Chat
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // checks row
        for (int row = 0; row < board.length; row++) {
            // initialize isValid array or set, if contains multiple return false;
            Set<Character> count = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[row][i] != '.' && !count.add(board[row][i])) return false;
            }
        }
        // checks column
        for (int col = 0; col < board.length; col++) {
            // initialize isValid array or set, if contains multiple return false;
            Set<Character> count = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                if (board[i][col] != '.' && !count.add(board[i][col])) return false;
            }
        }
        //checks boxes
        for (int square = 0; square < board.length; square++) {
            Set<Character> count = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] != '.' && !count.add(board[row][col])) return false;
                }
            }
        }

        return true;
    }
}
