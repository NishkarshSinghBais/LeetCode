// https://www.geeksforgeeks.org/problems/subset-sums2234/1

class Solution {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        int sum = 0;
        subsets(idx, sum, arr, list);
        return list;
    }

    void subsets(int idx, int sum, int[] arr, ArrayList<Integer> list){
        if ( idx == arr.length ){
            list.add(sum);
            return;
        }
        // include arr[idx]
        subsets(idx+1, sum + arr[idx], arr, list);
        // exclude arr[idx]
        subsets(idx+1, sum, arr, list);
    }
}