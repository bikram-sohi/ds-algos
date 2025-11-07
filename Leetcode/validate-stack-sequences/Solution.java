class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        int n = pushed.length;

        for(int i = 0; i < n; i++) {
            stack.push(pushed[i]);
            while(!stack.isEmpty() && j < n && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        
        return stack.isEmpty();
    }
}
