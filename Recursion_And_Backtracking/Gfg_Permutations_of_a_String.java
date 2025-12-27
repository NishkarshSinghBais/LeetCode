// https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1

// Time - N! * N and Space - N! * N

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> ans = new ArrayList<>();
        char[] arr = s.toCharArray();
        solve(0, arr, ans);
        return ans;
    }
    void solve(int start, char[] arr, ArrayList<String> ans){
        if ( start == arr.length ){
            ans.add(new String(arr));
            return;
        }

        Set<Character> set = new HashSet<>();

        for (int i=start; i<arr.length; i++){
            if ( set.contains(arr[i]) ){
                continue;
            }

            set.add(arr[i]);
            swap(i, start, arr);
            solve(start+1, arr, ans);
            swap(i, start, arr);
        }
    }

    void swap(int i, int start, char[] arr){
        char temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
    }
}