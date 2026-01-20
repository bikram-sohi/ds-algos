class Solution {
    public int largestRectangleArea(int[] heights) {  
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while(!stack.isEmpty() && h < heights[stack.peek()]) {       
                int height =  heights[stack.pop()];
                int right = i - 1;
                int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                int width = right - left + 1;

                maxArea = Math.max(maxArea, width * height);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
