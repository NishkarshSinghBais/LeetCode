// https://leetcode.com/problems/fruit-into-baskets/description/

// think it as to find maximum length subarray with at most 2 types of numbers.

// Brute Force - Time O(n)square and Space O(1)

class Solution {
    public int totalFruit(int[] fruits) {
        int maxLength = 0;
        for (int i=0; i<fruits.length; i++){
            Set<Integer> set = new HashSet<>();
            for (int j=i; j<fruits.length; j++){
                set.add(fruits[j]);
                if ( set.size() > 2 ){
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}

// Sliding Window - Time O(n) Space O(1)

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while ( j < fruits.length ){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            if ( map.size() <= 2 ){
                maxLength = Math.max(maxLength, j - i + 1);
            }

            while ( map.size() > 2 ){
                if ( map.containsKey(fruits[i]) ){
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                    if ( map.get(fruits[i]) == 0 ){
                        map.remove(fruits[i]);
                    }
                }
                i++;
            }
            j++;
        }
        return maxLength;
    }
}

