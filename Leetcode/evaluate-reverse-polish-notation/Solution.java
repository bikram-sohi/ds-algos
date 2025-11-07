class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String str: tokens) {
            switch(str) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;
                case "-": {
                    int first = s.pop();
                    int second = s.pop();
                    s.push(second - first);
                    break;
                }
                case "/": {
                    int first = s.pop();
                    int second = s.pop();
                    s.push(second / first);
                    break;
                }
                case "*":
                    s.push(s.pop() * s.pop());
                    break;
                default:
                    s.push(Integer.parseInt(str));
            }
        }
        return s.pop();
    }
}
