// https://leetcode.com/problems/word-break-ii/description/

// Time - n*2^n and Space - n*k (k=number of sentences)

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        solve(0, new StringBuilder(), s, set, ans);
        return ans;
    }
    void solve(int idx, StringBuilder sb, String s, Set<String> set, List<String> ans){
        if ( idx == s.length() ){
            ans.add(sb.toString().trim());
            return;
        }
        for (int i=idx; i<s.length(); i++){
            if (set.contains(s.substring(idx, i+1))){
                int len = sb.length();
                sb.append(" " + s.substring(idx, i+1));
                solve(i+1, sb, s, set, ans);
                sb.setLength(len);
            }
        }
    }
}