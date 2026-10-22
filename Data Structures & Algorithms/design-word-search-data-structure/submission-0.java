class WordDictionary {

    class TrieNode 
    {
        TrieNode [] children = new TrieNode[26]; 
        boolean eow = false;
    }
    public WordDictionary() {

    }
   TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode curr = root;
        int idx = 0;
        for(int i = 0 ; i < word.length() ; i++)
        {
            idx = word.charAt(i) - 'a';
            if(curr.children[idx]==null)
            {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
       
    }

   
         public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode root) {
        TrieNode curr= root;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children[c - 'a'] == null) {
                    return false;
                }
                curr= curr.children[c - 'a'];
            }
        }
        return curr.eow;
    }
}
