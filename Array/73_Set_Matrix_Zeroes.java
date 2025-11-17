// https://leetcode.com/problems/set-matrix-zeroes/
// Brute Force Time Complexity - O(n)cube

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // First pass: if an element is 0, mark its entire row and column as -1
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( matrix[i][j] == 0 ){
                    setRow(matrix, i, m);
                    setCol(matrix, j, n);
                }
            }
        }

        // Second Pass - Mark All -1 to Zero
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( matrix[i][j] == -111 ){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // Marks all non-zero elements in the given row as -1 (temporary marker)
    void setRow(int[][] matrix, int i, int m){
        for (int j=0; j<m; j++){
            if ( matrix[i][j] != 0 ){
                matrix[i][j] = -111;
            }
        }
    }

    // Marks all non-zero elements in the given column as -1 (temporary marker)
    void setCol(int[][] matrix, int j, int n){
        for (int i=0; i<n; i++){
            if ( matrix[i][j] != 0 ){
                matrix[i][j] = -111;
            }
        }
    }
}


// Optimal One : Time Complexity: O(n × m) and Space Complexity: O(n + m)

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Arrays to mark which rows and columns need to be zeroed
        int[] row = new int[n];
        int[] col = new int[m];

        // Step 1: Identify all rows and columns that contain at least one zero
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if ( matrix[i][j] == 0 ){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        // Step 2: Set elements to zero based on the marked rows and columns
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                // If either the row or column is marked, make this cell zero
                if ( row[i] == 1 || col[j] == 1 ){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}