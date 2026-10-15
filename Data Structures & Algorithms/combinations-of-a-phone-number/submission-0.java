
class Solution {
    Map<Character, String> mp = new HashMap<>();
    List<String> result = new ArrayList<>();
    StringBuilder curr = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return result;
        }

        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        backtrack(digits, 0);

        return result;
    }

    void backtrack(String digits, int i) {
        if (i == digits.length()) {
            result.add(curr.toString());
            return;
        }

        char digit = digits.charAt(i);
        String letters = mp.get(digit);

        for (int j = 0; j < letters.length(); j++) {
            char ch = letters.charAt(j);

            curr.append(ch);

            backtrack(digits, i + 1);

            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
