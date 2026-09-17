

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int low = 0;
        int maxf = 0;
        int ans = 0;

        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);

            mp.put(ch, mp.getOrDefault(ch, 0) + 1);

            maxf = Math.max(maxf, mp.get(ch));

            int replacements = (high - low + 1) - maxf;

            if (replacements > k) {
                char leftch = s.charAt(low);
                mp.put(leftch, mp.get(leftch) - 1);
                low++;
            }

            int ss = high - low + 1;
            ans = Math.max(ans, ss);
        }

        return ans;
    }
}