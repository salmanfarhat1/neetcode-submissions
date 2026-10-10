class MinStack {
    Stack<Integer> numbers; 
    Stack<Integer> minNumber; 
    int min = Integer.MAX_VALUE; 
    
    public MinStack() {
        numbers = new Stack<>();
        minNumber = new Stack<>();
    }
    
    public void push(int val) {
        numbers.push(val);
        min = Math.min(min, val);
        minNumber.push(min); 
    }
    
    public void pop() {
        numbers.pop(); 
        minNumber.pop(); 
        min = minNumber.isEmpty() ? Integer.MAX_VALUE : minNumber.peek(); 
    }
    
    public int top() {
        return numbers.peek(); 
    }
    
    public int getMin() {
        return minNumber.peek(); 
    }
}
