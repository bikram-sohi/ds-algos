class Solution {
    public List<String> commonChars(String[] words) {
        int[] first = count(words[0]);

        for(int i = 1; i < words.length; i++){
            first = intersection(first, count(words[i]));
        }

        List<String> arr =new ArrayList<>();
        for(int i = 0; i < 26; i++){
            if(first[i]!= 0){
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while(first[i] > 0){
                    arr.add(s);
                    first[i]--;
                }
            }
        }
        return arr;
    }

    private int[] count(String str){
        int[] t = new int[26];
        for(char c : str.toCharArray()) {
            t[c - 'a']++;
        }
        return t;
    }

    private int[] intersection(int[] a,int[] b) {
        int[] t = new int[26];
        for(int i = 0; i < 26; i++){
            t[i] = Math.min(a[i], b[i]);
        }
        return t;
    }
}
