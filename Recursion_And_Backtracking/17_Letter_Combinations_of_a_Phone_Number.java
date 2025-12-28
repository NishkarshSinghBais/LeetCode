// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

// Time 4^n and Space - n*4^n where n = recursion depth and 4^n total combinations

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0){
            return ans;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        solve(0, new StringBuilder(), map, digits, ans);
        return ans;
    }
    void solve(int idx, StringBuilder sb, Map<Character, String> map, String digits, List<String> ans){
        if ( idx == digits.length() ){
            ans.add(sb.toString());
            return;
        }

        char currDig = digits.charAt(idx);
        String letters = map.get(currDig);

        for (int i=0; i<letters.length(); i++){
            char ch = letters.charAt(i);
            sb.append(ch);
            solve(idx+1, sb, map, digits, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}