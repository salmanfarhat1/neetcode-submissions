class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length]; 
        int[] backward = new int[nums.length]; 
        forward[0] =1; 
        backward[nums.length - 1 ] = 1; 
        int mul = 1; 
        for(int i = 1; i < forward.length; i++){
            mul *= nums[i - 1]; 
            forward[i] = mul; 
        }
        mul = 1; 
        for(int i = nums.length -2; i >= 0; i--){
            mul *= nums[i + 1]; 
            backward[i] = mul; 
        }

        for(int i = 0; i < nums.length;i++){
            nums[i] = forward[i] * backward[i];
        }
        return nums;
    }
}  


/* Notes 
[1,2,4,6]
[2 * 4 *6 , 1 * 4 * 6, 1 * 2 *6 , 1 * 2 * 4]

[1, 1,  1 * 2 , 1 * 2 * 4]

[2 * 4 * 6, 4 * 6 , 6, 1] 

1 * 2 * 4 * 6, 1  * 4 * 6 ,  1 * 2 * 6, 1 * 2 * 4 * 1


[1, -1, 0, 0 ,0 , 0]

[ 0, 1 *2 *3 , 2 * 3  , 3 , 1]

[0, -6]
*/ 
