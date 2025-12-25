// https://leetcode.com/problems/combination-sum-iii/description/

// Can Also Done By Making Array from 1 to 9...
// LeetCode will show you fatser that way, but isn't...

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        validComb(idx, k, n, list, ans);
        return ans;
    }
    void validComb(int idx, int k, int n, List<Integer> list, List<List<Integer>> ans){
        if ( n == 0 && k == 0 ){
            ans.add(new ArrayList<>(list) );
            return;
        }

        // pruning, if either of one happens
        if ( k == 0 || n < 0 ){
            return;
        }

        for (int i=idx; i<=9; i++){
            // pruning
            if (  i > n ){
                break;
            }
            list.add(i);
            validComb(i+1, k-1, n-i, list, ans);
            list.remove(list.size() - 1);
        }
    }
}