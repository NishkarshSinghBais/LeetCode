// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

// Brute Force - Time - O(m! * m + n * m) and Space - O(m! * m)

class Solution {

    int search(String pat, String txt) {
        // code here
        String str = "";
        HashSet<String> set = new HashSet<>();
        permutation(str, set, pat);

        int i = 0;
        int j = 0;
        int count = 0;

        while ( j < txt.length() ){
            if ( j - i + 1 < pat.length() ){
                j++;
            } else if ( j - i + 1 == pat.length() ){
                String s = txt.substring(i, j+1);
                if ( set.contains(s)){
                    count++;
                }
                i++;
                j++;
            }
        }
        return count;
    }

    void permutation(String str, HashSet<String> set, String pat){
        if ( pat.isEmpty() ){
            set.add(str);
            return;
        }
        char ch = pat.charAt(0);

        for (int i=0; i<=str.length(); i++){
            String f = str.substring(0, i);
            String l = str.substring(i);
            permutation(f+ch+l, set, pat.substring(1));
        }
    }
}

// Optimal Approach - Time O(n)



