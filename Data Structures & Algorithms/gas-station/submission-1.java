class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length; 
        int total = 0;
        int curTank =0; 
        int result = 0; 
        for(int i = 0; i < n; i++){
           total += gas[i] - cost[i]; 
           curTank += gas[i] - cost[i];
           if(curTank < 0){
                curTank = 0; 
                result = i + 1;
           }
        } 
        return (total < 0) ? -1 : result; 
    }
}
