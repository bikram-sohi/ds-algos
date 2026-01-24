class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> hm = new HashMap<>();

        for(int[] point: points) {
            if(!hm.containsKey(point[0])) {
                hm.put(point[0], new HashSet<Integer>());
            }
            hm.get(point[0]).add(point[1]);
        }

        int minArea = Integer.MAX_VALUE;

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                int x1 = points[i][0], x2 = points[j][0];
                int y1 = points[i][1], y2 = points[j][1];
                if(x1 != x2 && y1 != y2) {
                    if(hm.get(x1).contains(y2) && hm.get(x2).contains(y1)) {
                        minArea = Math.min(minArea, Math.abs(x1 - x2) * Math.abs(y1 - y2));
                    }
                } 
            }
        }

        return minArea != Integer.MAX_VALUE ? minArea : 0;
    }
}
