class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String str: strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String sstr = new String(carr);
            if (!hm.containsKey(sstr)) {
                hm.put(sstr, new ArrayList<>());
            }
            hm.get(sstr).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}
