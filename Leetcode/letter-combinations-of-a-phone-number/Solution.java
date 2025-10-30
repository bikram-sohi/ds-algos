class Solution {
    String[] phone = {
        "0",
        "1",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        unique(digits, 0, new char[digits.length()], res);
        return res;
    }

    void unique(String digits, int idx, char[] temp, List<String> res) {
        if(idx == digits.length()) {
            res.add(new String(temp));
            return;
        }

        int cur = digits.charAt(idx) - '0';

        for(int i = 0; i < phone[cur].length(); i++) {
            temp[idx] = phone[cur].charAt(i);
            unique(digits, idx + 1, temp, res);
        }
    }
}
