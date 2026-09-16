
class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Put all elements in HashSet
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // Step 2: Check every number
        for (int num : set) {

            // num is the starting point
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Check next consecutive numbers
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}