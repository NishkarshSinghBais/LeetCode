// https://leetcode.com/problems/word-break/description/

// Brute Force - TLE on LeetCode

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return solve(0, s, wordDict);
    }
    boolean solve(int idx, String s, List<String> wordDict){
        if (idx == s.length()){
            return true;
        }

        for(int i=idx; i<s.length(); i++){
            if (wordDict.contains(s.substring(idx, i+1))){
                if (solve(i+1, s, wordDict)){
                    return true;
                }
            }
        }
        return false;
    }
}

//