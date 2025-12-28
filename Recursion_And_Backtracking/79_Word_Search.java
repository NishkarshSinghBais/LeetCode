// https://leetcode.com/problems/word-search/description/

// Time - n*m*4^l (4 direction, l: depth of recursion ) and Time n*m+l (l: lenght of word)

class Solution {

    int n, m;
    int[] di = {0, -1, 0, 1};
    int[] dj = {-1, 0, 1, 0};

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( board[i][j] == word.charAt(0) && check(1, i, j, vis, board, word)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean check(int idx, int i, int j, boolean[][] vis, char[][] board, String word){
        if ( idx == word.length()){
            return true;
        }
        vis[i][j] = true;
        for (int k=0; k<4; k++){
            int ni = i + di[k];
            int nj = j + dj[k];
            if ( ni >= 0 && nj >= 0 && ni < n && nj < m && board[ni][nj] == word.charAt(idx) && !vis[ni][nj]){
                if (check(idx + 1, ni, nj, vis, board, word)){
                    return true;
                }
            }
        }
        vis[i][j] = false;
        return false;
    }
}