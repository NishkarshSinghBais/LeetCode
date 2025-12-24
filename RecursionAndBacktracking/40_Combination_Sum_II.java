// https://leetcode.com/problems/combination-sum-ii/description/

// Time 2^n (maximum number of subsets) and Space O(n)

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        int start = 0;
        findCombinationSum2(start, candidates, target, list, ans);
        return ans;
    }
    void findCombinationSum2(int start, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans){

        if ( target == 0 ){
            ans.add(new ArrayList<>(list));
            return;
        }

        for ( int i=start; i<candidates.length; i++){
            // skip duplicates at the same recursion level
            // not across different recursion levels
            if ( i > start && candidates[i] == candidates[i - 1] ){
                continue;
            }

            if ( candidates[i] > target ){
                break;
            }
            list.add(candidates[i]);
            findCombinationSum2(i + 1, candidates, target - candidates[i], list, ans);
            list.remove(list.size() - 1);
        }
    }
}