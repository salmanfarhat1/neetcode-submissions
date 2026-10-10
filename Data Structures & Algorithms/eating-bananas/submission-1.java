class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE; 
        for(int i =0; i < piles.length; i++)
            if(piles[i] > max)
                max= piles[i];
        int left = 1; 
        int right = max; 
        int mid = -1; 
        int answer = 0; 
        while(left <= right){
             mid = left + (right - left )/2; 
            if(canFinish(piles, h, mid)){
                answer = mid;
                right = mid - 1; 
                
            }
            else{
                left = mid + 1; 
            }
        }
        return  answer;
    }
    public boolean canFinish(int[] piles, int h, int rate){
        int sum = 0; 
        for(int i = 0; i < piles.length; i++){
            sum = (piles[i] % rate == 0) ? sum + piles[i] / rate : sum + piles[i] / rate + 1; 
            if(sum > h) 
                return false;
        }
        return true;
    }
}
