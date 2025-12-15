class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, new StringBuilder());
        return result;
    }

    private void generate(int n, int left, int right, StringBuilder sb){
        if(left == n && right == n) {
            result.add(sb.toString());
        }

        if(left < n) {
            sb.append("(");
            generate(n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left) {
            sb.append(")");
            generate(n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
