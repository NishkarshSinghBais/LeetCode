// https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

// Brute Force - Double for loop

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();

        for (int i=0; i<=arr.length - k; i++){
            int max = Integer.MIN_VALUE;
            for (int j=i; j<i+k; j++){
                if ( arr[j] > max ){
                    max = arr[j];
                }
            }
            list.add(max);

        }
        return list;
    }
}

// Optimal One -> O(n)

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();

        int i=0;
        int j=0;

        while ( j < arr.length ){
            while ( dq.size() != 0 && dq.peekLast() < arr[j] ){
                dq.removeLast();
            }
            dq.offerLast(arr[j]);

            if ( j - i + 1 < k ){
                j++;
            } else if ( j - i + 1 == k ){
                list.add(dq.peekFirst());

                if ( arr[i] == dq.peekFirst() ){
                    dq.removeFirst();
                }
                i++;
                j++;
            }
        }
        return list;
    }
}