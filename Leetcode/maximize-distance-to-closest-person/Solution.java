class Solution {
    public int maxDistToClosest(int[] seats) {
        int max = 0;
        int last = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                if (last == -1) max = i + 1;
            }
            else {
                max = Math.max((i - last) / 2, max);
                last = i;
            }
        }
        return Math.max(max, seats.length - last - 1);
    }
}
