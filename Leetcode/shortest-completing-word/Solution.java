class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = new int[26];

        for(char c: licensePlate.toCharArray()){
            if(Character.isLetter(c)){
                target[Character.toLowerCase(c) - 'a']++;
            }
        }
        
        String res = null;

        for(String word: words){
            if(isComplete(word, target)){
                if(res == null || word.length() < res.length()){
                    res = word;
                }
            }
        }

        return res;
    }

    private boolean isComplete(String word, int[] target){
        int[] cnt = new int[26];

        for(char c: word.toCharArray()){
            cnt[c - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            if(cnt[i] < target[i]){
                return false;
            }
        }

        return true;
    }
}
