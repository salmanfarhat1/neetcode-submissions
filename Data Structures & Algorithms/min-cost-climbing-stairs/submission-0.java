class Solution {
    public int minCostClimbingStairs(int[] cost) {
       return Math.min(takeOrSkip(cost, 0 , 0), takeOrSkip(cost, 1, 0));
    }

    public int takeOrSkip(int[] cost, int index, int curCost)
    {
        if(index >= cost.length)
            return curCost;
        int r1 = takeOrSkip(cost , index + 1 , curCost + cost[index]); 
        int r2 = takeOrSkip(cost , index + 2 , curCost + cost[index]); 
        return Math.min(r1, r2); 
    } 
}
