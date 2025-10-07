class Solution {

    class Pair{
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        LinkedList<Pair> current = new LinkedList<>();
        LinkedList<Pair> next = new LinkedList<>();

        int passes = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    current.offer(new Pair(i, j));
                }
            }
        }

        while(!current.isEmpty()) {
            while(!current.isEmpty()) {
                Pair p = current.poll();
                if(p.x > 0 && grid[p.x - 1][p.y] == 1) {
                    grid[p.x - 1][p.y] = 2;
                    next.offer(new Pair(p.x - 1, p.y));
                }
                if(p.x < grid.length - 1 && grid[p.x + 1][p.y] == 1) {
                    grid[p.x + 1][p.y] = 2;
                    next.offer(new Pair(p.x + 1, p.y));
                }
                if(p.y > 0 && grid[p.x][p.y - 1] == 1) {
                    grid[p.x][p.y - 1] = 2;
                    next.offer(new Pair(p.x, p.y - 1));
                }
                if(p.y < grid[0].length - 1 && grid[p.x][p.y + 1] == 1) {
                    grid[p.x][p.y + 1] = 2;
                    next.offer(new Pair(p.x, p.y + 1));
                }
            }
            LinkedList<Pair> temp;
            temp = current;
            current = next;
            next = temp;
            passes++;
        }

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return passes == 0 ? 0 : passes - 1;
    }
}
