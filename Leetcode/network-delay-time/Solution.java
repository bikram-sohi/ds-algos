class Tuple {
    int first;
    int second;

    Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] time: times) {
            adj.get(time[0] - 1).add(new Tuple(time[1] - 1, time[2]));
        }

        PriorityQueue<Tuple> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.second));
        int[] visitedTimes = new int[n];
        Arrays.fill(visitedTimes, Integer.MAX_VALUE);
        visitedTimes[k - 1] = 0;

        q.add(new Tuple(k - 1, 0));

        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int node = t.first;
            int time = t.second;

            for(Tuple edge: adj.get(node)) {
                int adjnode = edge.first;
                int adjtime = edge.second;

                if(visitedTimes[adjnode] > time + adjtime) {
                    visitedTimes[adjnode] = time + adjtime;
                    q.add(new Tuple(adjnode, visitedTimes[adjnode]));
                }
            }
        }

        int maxTime = 0;
        for (int time : visitedTimes) {
            if (time == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, time);
        }

        return maxTime;
    }
}
