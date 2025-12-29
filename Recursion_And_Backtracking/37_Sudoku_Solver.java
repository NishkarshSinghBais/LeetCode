// https://leetcode.com/problems/sudoku-solver/description/

// Time - 9^E (E: no. of empty cells) and Space - E recursion satck (else O(1) xtra space)

class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    boolean solve(char[][] board){
        int n = board.length;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (board[i][j] == '.'){
                    for (int k=1; k<=9; k++){
                        if (isValid(i, j, k, board)){
                            board[i][j] = (char)(k + '0');
                            if (solve(board)){
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    boolean isValid(int i, int j, int k, char[][] board){
        for (int l=0; l<9; l++){
            if ( board[i][l] == (char)(k + '0') ){
                return false;
            }
        }
        for (int l=0; l<9; l++){
            if ( board[l][j] == (char)(k + '0') ){
                return false;
            }
        }
        for (int x=(i/3)*3; x<(i/3)*3+3; x++){
            for (int y=(j/3)*3; y<(j/3)*3+3; y++){
                if ( board[x][y] == (char)(k + '0') ){
                    return false;
                }
            }
        }
        return true;
    }
}