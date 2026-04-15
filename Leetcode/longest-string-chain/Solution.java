class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> hm = new HashMap<>();
        String[] sorted = Arrays.copyOf(words, words.length);
        Arrays.sort(sorted, (a, b) -> a.length() - b.length());

        int res = 1;

        for(String word: sorted) {
            hm.put(word, 1);

            for(int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);
                if(hm.containsKey(pred)) {
                    int val = Math.max(hm.get(word), hm.get(pred) + 1);
                    hm.put(word, val);
                    res = Math.max(res, val);
                }
            }
        }

        return res;
    }
}
