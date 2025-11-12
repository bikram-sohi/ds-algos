class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    void backtrack(String s, int i, List<String> parts, List<String> res) {
        if(parts.size() == 4) {
            if(i == s.length()) res.add(String.join(".", parts));
            return;
        }

        for(int j = 1; j <= 3 && i + j <= s.length(); j++) {
            String cur = s.substring(i, i + j);
            if(!isValid(cur)) break;
            parts.add(cur);
            backtrack(s, i + j, parts, res);
            parts.remove(parts.size() - 1);
        }
    }

    Boolean isValid(String s) {
        if(Long.parseLong(s) > 255) {
            return false;
        }
        return !(s.length() > 1 && s.charAt(0) == '0');
    } 
}
