class Solution {
    public List<String> generateParenthesis(int n) {
        char[] chars = new char[2 * n];
        for (int i = 0; i < n; i++) {
            chars[i] = '(';
            chars[2 * n - 1 - i] = ')';
        }
        List<String> result = new ArrayList<>();
        backtrack(chars, n, new ArrayList<>(), result, 0, 0);
        return result;
    }
    public void backtrack(
        char[] chars,
        int n,
        List<Character> path,
        List<String> result,
        int left,
        int right
    ) {

        if (left == n && right == n) {
            result.add(charsToString(path));
            return;
        }

        if (left < n) {
            path.add('(');
            backtrack(chars, n, path, result, left + 1, right);
            path.remove(path.size() - 1);
        }
        if (right < left) {
            path.add(')');
            backtrack(chars, n, path, result, left, right + 1);
            path.remove(path.size() - 1);
        }
    }
    public String charsToString(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}