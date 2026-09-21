class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            mp2.put(ch, mp2.getOrDefault(ch, 0) + 1);
        }

        int low = 0;
        int count = 0;

        int minLength = Integer.MAX_VALUE;
        String ans = "";

        // sliding window
        for(int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);

        
            if(mp2.containsKey(ch)) {

                mp1.put(ch, mp1.getOrDefault(ch, 0) + 1);

               
                if(mp1.get(ch) <= mp2.get(ch)) {
                    count++;
                }
            }

            while(count == t.length()) {

            
                if(high - low + 1 < minLength) {
                    minLength = high - low + 1;
                    ans = s.substring(low, high + 1);
                }

                char left = s.charAt(low);

                if(mp2.containsKey(left)) {

                    mp1.put(left, mp1.get(left) - 1);

                    // ab required character kam ho gaya
                    if(mp1.get(left) < mp2.get(left)) {
                        count--;
                    }
                }

                low++;
            }
        }

        return ans;
    }
}