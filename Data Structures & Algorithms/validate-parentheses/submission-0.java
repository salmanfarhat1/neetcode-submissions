class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()){
            if(c == '[' || c == '{' || c =='(')
                stack.push(c);
            else{
                char peeked = (stack.isEmpty()) ? 'p' : stack.peek(); 
                if((peeked != '{' && c == '}') || 
                        (peeked != '(' && c == ')') || 
                            (peeked != '[' && c == ']') )
                    return false; 
                stack.pop(); 
            } 
        }  
        return stack.isEmpty(); 
    }
}


/* Notes: 
Stack [  ]
*/ 
