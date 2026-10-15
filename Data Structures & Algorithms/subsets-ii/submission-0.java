
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        solve(nums, curr, result, 0);

        return result;
    }

    void solve(int[] nums, List<Integer> curr,
               List<List<Integer>> result, int i) {

        result.add(new ArrayList<>(curr));

        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }

            curr.add(nums[j]);

            solve(nums, curr, result, j + 1);

            curr.remove(curr.size() - 1);
        }
    }
}
