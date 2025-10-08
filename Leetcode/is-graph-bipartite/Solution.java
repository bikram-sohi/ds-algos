class Solution {
    static boolean dfs(int curr, int[] color, int[][] graph) {

        for(int nbr : graph[curr]) {
            if(color[nbr] == -1) {
                color[nbr] = 1 - color[curr];
                boolean flag = dfs(nbr, color, graph);
                if(!flag) {
                    return false;
                }
            } else if(color[nbr] == color[curr]) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for(int i = 0; i < n; i++) {
            color[i] = -1;
        }
        
        for(int i = 0; i < n; i++) {
            if(color[i] == -1) {
                color[i] = 0;
                boolean result = dfs(i, color, graph);

                if(!result) {
                    return false;
                }
            }
        }

        return true;
        
    }
}
