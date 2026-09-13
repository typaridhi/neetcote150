class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for(String st : strs )
        {
               ans.append(st.length());
            ans.append("@");
            ans.append(st);
        }
        return ans.toString();
    }

    public List<String> decode(String str) {
         List<String> ans = new ArrayList<>();

        int i =0, j;
        while (i < str.length())
        {
            j =i ;
            while(str.charAt(j) != '@' )
            {
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            
        String word = str.substring(j + 1, j + 1 + len);

            ans.add(word);

            i = j + 1 + len;
        }

        return ans;

    }
}
