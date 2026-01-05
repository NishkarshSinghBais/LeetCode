// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

// Brute Force - Time - O(n * k)

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<=arr.length - k; i++){
            int firstNeg = 0;
            for (int j=i; j<i+k; j++){
                if ( arr[j] < 0 ){
                    firstNeg = arr[j];
                    break;
                }
            }
            list.add(firstNeg);
        }
        return list;
    }
}

// Optimal One - Time O(n)

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int i=0;
        int j=0;

        while ( j < arr.length ){
            if ( arr[j] < 0 ){
                q.offer(arr[j]);
            }

            if ( j - i + 1 < k ){
                j++;
            } else if ( j - i + 1 == k ){
                if ( q.isEmpty() ){
                    list.add(0);
                } else {
                    list.add(q.peek());
                }
                if ( !q.isEmpty() && arr[i] == q.peek()){
                    q.remove();

                }
                // Always increase within else-if
                // to stop increasing i before reaching window size
                i++;
                j++;

            }
        }
        return list;
    }
}