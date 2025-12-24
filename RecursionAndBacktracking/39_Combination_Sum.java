// https://leetcode.com/problems/combination-sum/description/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        findCombinationSum(idx, candidates, target, list, ans);
        return ans;
    }

    public void findCombinationSum(int idx, int[] candidates, int target, List<Integer> list, List<List<Integer>> ans){

        if ( idx == candidates.length ){
            if ( target == 0 ){
                // Store copy of list, not the real reference beacuase
                // while backtracking, when we remove elements from the list
                // it will manipulate the list which we saved in ans
                // because it is refering to the same memory address... now you know
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        if ( candidates[idx] <= target ){
            list.add(candidates[idx]);
            findCombinationSum(idx, candidates, target - candidates[idx], list, ans);
            list.remove(list.size() - 1);
        }
        findCombinationSum(idx + 1, candidates, target, list, ans);
    }
}