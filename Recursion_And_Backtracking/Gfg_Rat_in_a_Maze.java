// https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

// Time - O(4^n^2) and Space - O(n^2)

// With Direction Array

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        if ( maze[0][0] == 0 || maze[n-1][n-1] == 0 ){
            return ans;
        }

        // Lexicographically/Dictionary Order - DLRU
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        solve(0, 0, n, di, dj, dir, "", vis, maze, ans);
        return ans;
    }

    void solve(int i, int j, int n, int[] di, int[] dj, char[] dir, String path, boolean[][] vis, int[][] maze, ArrayList<String> ans){
        if ( i == n-1 && j == n-1 ){
            ans.add(path);
            return;
        }

        vis[i][j] = true;

        for (int k=0; k<4; k++){
            int ni = i + di[k];
            int nj = j + dj[k];

            if ( ni >= 0 && nj >= 0 && ni < n && nj < n && maze[ni][nj] == 1 && !vis[ni][nj] ){
                solve(ni, nj, n, di, dj, dir, path + dir[k], vis, maze, ans);
            }
        }

        vis[i][j] = false;
    }
}

// Without Direction Array

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int n = maze.length;
        ArrayList<String> ans = new ArrayList<>();
        boolean[][] vis = new boolean[n][n];
        if ( maze[0][0] == 0 || maze[n-1][n-1] == 0 ){
            return ans;
        }
        solve(0, 0, n, "", vis, maze, ans);
        return ans;
    }

    void solve(int i, int j, int n, String path, boolean[][] vis, int[][] maze, ArrayList<String> ans){
        if ( i == n-1 && j == n-1 ){
            ans.add(path);
            return;
        }

        vis[i][j] = true;

        // Lexicographically/Dictionary Order - DLRU

        //down
        if ( i+1 < n && maze[i+1][j] == 1 && !vis[i+1][j] ){
            solve(i+1, j, n, path + "D", vis, maze, ans);
        }

        //Left
        if ( j-1 >= 0 && maze[i][j-1] == 1 && !vis[i][j-1] ){
            solve(i, j-1, n, path + "L", vis, maze, ans);
        }

        //Right
        if ( j+1 < n && maze[i][j+1] == 1 && !vis[i][j+1] ){
            solve(i, j+1, n, path + "R", vis, maze, ans);
        }

        //up
        if ( i-1 >= 0 && maze[i-1][j] == 1 && !vis[i-1][j] ){
            solve(i-1, j, n, path + "U", vis, maze, ans);
        }

        vis[i][j] = false;
    }
}