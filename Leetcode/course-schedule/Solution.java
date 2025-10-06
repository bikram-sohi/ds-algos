// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<Integer>[] adj = new List[numCourses];
//         int[] degree = new int[numCourses];
//         int ans = 0;

//         for(int[] pair: prerequisites) {
//             if(adj[pair[0]] == null) {
//                 adj[pair[0]] = new ArrayList<>();
//             }
//             adj[pair[0]].add(pair[1]);
//             degree[pair[1]]++;
//         }

//         Queue<Integer> q = new LinkedList();
//         for(int i = 0; i < numCourses; i++) {
//             if(degree[i] == 0) {
//                 q.offer(i);
//             }
//         }

//         while(!q.isEmpty()) {
//             int current = q.poll();
//             ans++;

//             if(adj[current] != null) {
//                 for(int next : adj[current]) {
//                     degree[next]--;
//                     if(degree[next] == 0) {
//                         q.offer(next);
//                     }
//                 }
//             }
//         }
//         return ans == numCourses;
//     }
// }

class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] adj = new List[n];

        for(int[] pair: prerequisites) {
            if(adj[pair[0]] == null) {
                adj[pair[0]] = new ArrayList<>();
            }
            adj[pair[0]].add(pair[1]);
        }

        int[] col = new int[n];

        for(int i = 0; i < col.length; i++) {
            if(col[i] == 0) {
                boolean check = isCycle(adj, col, i);
                if(check) return false;
            }
        }
        return true;
    }

    boolean isCycle(List<Integer>[] adj, int[] col, int i) {
        col[i] = 1;
        if(adj[i] != null) {
            for(int c : adj[i]) {
                if(col[c] == 1) return true;
                if(col[c] == 0) {
                    boolean check = isCycle(adj, col, c);
                    if(check) return true;
                }

            }
        }
        col[i] = 2;
        return false;
    }
}


