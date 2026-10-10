class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack(); 
        int[] res = new int[temperatures.length];
        for(int i = temperatures.length -1 ; i >= 0; i-- ){
            while(!stack.isEmpty() && 
                temperatures[stack.peek()] < temperatures[i]){
                    stack.pop(); 
            }  
            if(stack.isEmpty()){
                res[i] = 0; 
                stack.push(i); 
                continue; 
            }
            int index = stack.peek(); 
            res[i] = index - i;
            stack.push(i);
        }
        return res;
    }
}


/*Notes:
 -> brute force : O(n power 2) can we do better ? 

*/
