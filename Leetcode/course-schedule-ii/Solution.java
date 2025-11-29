// class Solution {
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> graph = new ArrayList<>();
//         int[] indegree = new int[numCourses];

//         for(int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }

//         for(int[] edge: prerequisites) {
//             int course = edge[0];
//             int prereq = edge[1];
//             graph.get(prereq).add(course);
//             indegree[course]++;
//         }
        
//         Queue<Integer> q = new ArrayDeque<>();
//         for(int i = 0; i < numCourses; i++) {
//             if(indegree[i] == 0) q.offer(i);
//         }

//         int[] order = new int[numCourses];
//         int idx = 0;

//         while(!q.isEmpty()) {
//             int cur = q.poll();
//             order[idx++] = cur;

//             for(int adj: graph.get(cur)) {
//                 indegree[adj]--;
//                 if(indegree[adj] == 0) q.offer(adj);
//             }
//         }

//         return idx == numCourses? order : new int[0];
//     }
// }

class Solution {
    List<List<Integer>> graph;
    int[] state;
    int[] order;
    int idx;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        graph = new ArrayList<>();
        state = new int[numCourses];
        order = new int[numCourses];
        idx = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i)) {
                    return new int[0];
                }
            }
        }

        return order;
    }

    private boolean dfs(int node) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;

        state[node] = 1;

        for (int next : graph.get(node)) {
            if (dfs(next)) return true;
        }

        state[node] = 2;
        order[idx--] = node;

        return false;
    }
}
