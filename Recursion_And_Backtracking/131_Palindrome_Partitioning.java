// https://leetcode.com/problems/palindrome-partitioning/description/

// Time - 2^N*N and Space - 2^N*N

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        solve(0, s, list, ans);
        return ans;
    }
    void solve(int start, String s, List<String> list, List<List<String>> ans){
        if ( start == s.length() ){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<s.length(); i++){
            if (isPalindrome(start, i, s)){
                list.add(s.substring(start, i+1)); // When Choosing Start - i
                solve(i+1, s, list, ans); // Always i+1 Remember
                list.remove(list.size() - 1);
            }
        }
    }
    boolean isPalindrome(int a, int b, String s){
        while ( a <= b ){
            if ( s.charAt(a) != s.charAt(b) ){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}