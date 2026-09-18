class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character , Integer > mp1 = new HashMap<>();
         HashMap <Character , Integer > mp2 = new HashMap<>();
         char ch;
        for(int i =0 ; i <s1.length() ;i++)
        {
            ch = s1.charAt(i);
            mp1.put(ch , mp1.getOrDefault(ch,0)+1);

        }
        int low =0;
        for(int high = 0; high < s2.length() ;high ++)
        {
            
            ch = s2.charAt(high);
            mp2.put(ch , mp2.getOrDefault(ch,0)+1);
           if(high - low + 1 > s1.length()) {
                char left = s2.charAt(low);

                mp2.put(left, mp2.get(left) - 1);

                if(mp2.get(left) == 0) {
                    mp2.remove(left);
                }

                low++;
            }
        
          if(mp1.equals(mp2))
            return true;
        }
        return false;
    }
}
