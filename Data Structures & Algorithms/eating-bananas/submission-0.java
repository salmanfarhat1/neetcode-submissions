class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE; 
        for(int i =0; i < piles.length; i++)
            if(piles[i] > max)
                max= piles[i];
        int prev = -1; 
        for(int i = 1; i <= max; i++){
            if(canFinish(piles , h, i))
                return i;
        }
        return -1 ;
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
