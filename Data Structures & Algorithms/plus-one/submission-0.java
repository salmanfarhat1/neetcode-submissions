class Solution {
    public int[] plusOne(int[] digits) {
        int reminder = 0; 
        for(int i = digits.length -1; i>= 0 ;i--){
            if(digits[i] == 9){
                reminder = 1; 
                digits[i] = 0; 
            }
            else{
                digits[i]++; 
                reminder = 0; 
                break; 
            }
        }
        
        if(reminder == 1){
            int[] result = new int[digits.length +1 ]; 
            result[0] =1; 
            return result; 
        }
        return digits; 


    }
}
