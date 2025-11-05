class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i = 1; i < (2 * n); i++) {
            int cur = i % n;
            while(!s.isEmpty() && nums[s.peek()] < nums[cur]) {
                res[s.pop()] = nums[cur];
            }
            if(i < n){
                s.push(cur);
            }
        }
        return res;
    }
}
