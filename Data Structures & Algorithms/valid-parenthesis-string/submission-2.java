
class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>(); // indices of '('
        Stack<Integer> starStack = new Stack<>(); // indices of '*'

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                openStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else { // ')'
                if (!openStack.isEmpty()) {
                    openStack.pop();       // match with a '(' first
                } else if (!starStack.isEmpty()) {
                    starStack.pop();       // otherwise use a '*' as '('
                } else {
                    return false;          // nothing to match this ')'
                }
            }
        }

        // Match leftover '(' with leftover '*'; the '*' must come AFTER the '('
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            int openIndex = openStack.pop();
            int starIndex = starStack.pop();
            if (starIndex < openIndex) return false; // '*' is before '(' so it can't close it
        }

        // Any '(' left over has no '*' to close it
        return openStack.isEmpty();
    }
}