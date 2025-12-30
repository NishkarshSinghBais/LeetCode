// https://leetcode.com/problems/n-queens/description/

// Time Worst (N!)

// Space (S + N * N^2) S = Total solutions, N = max Recursion depth, N^2 = board storage

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        solve(0, board, ans);
        return ans;
    }
    void solve(int row, char[][] board, List<List<String>> ans){
        int n = board.length;

        if ( row == n ){
            ans.add(construct(board));
            return;
        }

        for (int col=0; col<n; col++){
            if ( isValid(row, col, board) ){
                board[row][col] = 'Q';
                solve(row + 1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    boolean isValid(int row, int col, char[][] board){
        int n = board.length;

        // same column
        for (int i=0; i<row; i++){
            if (board[i][col] == 'Q'){
                return false;
            }
        }

        // upper left diagonal
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }

        // upper right diagonal
        for (int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if ( board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for (int i=0; i<board.length; i++){
            list.add(new String(board[i]));
        }
        return list;
    }
}