class DetectSquares {
    Map<Integer, Map<Integer, Integer>> x;

    public DetectSquares() {
        x = new HashMap<>();
    }
    
    public void add(int[] point) {
        x.computeIfAbsent(point[0], k -> new HashMap<>())
         .merge(point[1], 1, Integer::sum);
    }
    
    public int count(int[] point) {
        int x0 = point[0], y0 = point[1];
        int total = 0;

        Map<Integer, Integer> col = x.get(x0);
        if (col == null) return 0;

        for (Map.Entry<Integer, Integer> e : col.entrySet()) {
            int y1 = e.getKey();
            int freq = e.getValue();

            if (y1 == y0) continue;

            int diff = Math.abs(y1 - y0);

            Map<Integer, Integer> right = x.get(x0 + diff);
            if (right != null) {
                Integer a = right.get(y0);
                Integer b = right.get(y1);
                if (a != null && b != null) total += a * b * freq;
            }

            Map<Integer, Integer> left = x.get(x0 - diff);
            if (left != null) {
                Integer a = left.get(y0);
                Integer b = left.get(y1);
                if (a != null && b != null) total += a * b * freq;
            }
        }
        return total;
    }
}

