class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int val: asteroids) {
            Boolean destroyed = false;

            while(val < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int prev = stack.peek();

                if (Math.abs(prev) < Math.abs(val)) {
                    stack.pop();
                    continue;
                } else if (Math.abs(prev) == Math.abs(val)) {
                    stack.pop();
                }
                
                destroyed = true;
                break;
            }

            if(!destroyed) {
                stack.push(val);
            }      
        }

        int[] res = new int[stack.size()];

        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }
}
