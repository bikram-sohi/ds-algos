class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n <= 2) return n;
        int ans = 2;

        for(int[] a: points) {
            HashMap<Double, Integer> hm = new HashMap<>();
            for(int[] b: points) {
                if(a == b) continue;
                double slope = 0;
                if(a[0] - b[0] == 0) slope = Double.POSITIVE_INFINITY;
                else slope = (b[1] - a[1]) / (double)(b[0] - a[0]);

                hm.put(slope, hm.getOrDefault(slope, 1) + 1);
                ans = Math.max(ans, hm.get(slope));
            }
        }
        return ans;
    }
}
