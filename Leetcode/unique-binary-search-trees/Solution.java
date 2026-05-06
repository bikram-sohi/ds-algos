// class Solution {
//     public int numTrees(int n) {
//         int[] cache = new int[n + 1];
//         cache[0] = cache[1] = 1;
//         for(int i = 2; i <= n; i++) {
//             for(int j = 1; j <= i; j++) {
//                 cache[i] += cache[j - 1] * cache[i - j];
//             }
//         }
//         return cache[n];
//     }
// }

class Solution {
    int[] cache;
    public int numTrees(int n) {
        cache = new int[n + 1];
        cache[0] = cache[1] = 1;
        return g(n);
    }
    int g(int n) {
        if(cache[n] > 0) {
            return cache[n];
        }
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += g(i - 1) * g(n - i);
        }
        cache[n] = sum;
        return sum;
    }
}
