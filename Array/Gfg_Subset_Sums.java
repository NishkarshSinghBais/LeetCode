class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int n = arr.length;
        int sum = 0;
        solve(i, n, sum, list, arr);
        return list;
    }

    public void solve(int i, int n, int sum, ArrayList<Integer> list, int[] arr){
        if ( i == n ){
            list.add(sum);
            return;
        }
        // include arr[i]
        solve(i+1, n, sum + arr[i], list, arr);

        // exclude arr[i]
        solve(i+1, n, sum, list, arr);
    }
}