class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++){
            leftMax[i] = Math.max(height[i] , max);
            max = leftMax[i]; 
        } 
        max = Integer.MIN_VALUE;
        for(int i = height.length -1; i >= 0; i--){
            rightMax[i] = Math.max(height[i] , max);
            max = leftMax[i]; 
        } 
        int trappedWater = 0 ;
        for(int i = 0; i < height.length; i++){
            int left = (i == 0) ? 0 : leftMax[i];
            int right = (i == height.length - 1) ? 0 : rightMax[i]; 
            trappedWater += Math.min(left, right) - height[i]; 
        } 

        return trappedWater;
        
    }
}
