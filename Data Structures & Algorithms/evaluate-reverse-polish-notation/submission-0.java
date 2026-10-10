class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>(); 
        for(int i = 0; i < tokens.length; i++){
            String s = tokens[i];
            if(s.equals("+") 
                || s.equals("-") 
                ||s.equals("*") 
                || s.equals("/")){
                    int n2 = stack.pop();
                    int n1 = stack.pop(); 
                    stack.push(applyOperation(n1, n2, s));
            }
            else{
                int num = Integer.parseInt(s);
                stack.push(num);
            } 
        }
        return stack.pop(); 
    }
    public int applyOperation(int n1, int n2, String s){
        switch (s){
            case "+": 
                return n1 + n2; 
            case "-":
                return n1 - n2; 
            case "*":
                return n1 * n2;
            default: 
                return n1 / n2; 
        }
    }
}
