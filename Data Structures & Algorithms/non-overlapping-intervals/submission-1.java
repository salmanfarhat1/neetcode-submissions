class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        return backtrack(intervals, new ArrayList<>(), 0); 
    }
    public void printPath(List<int[]> path) {
        for (int[] interval : path) {
        }
    }
    public int backtrack(int[][] intervals, List<int[]> path, int index){
        if(index == intervals.length){

            printPath(path);
            if(nonOverLap(path)){
                return (intervals.length - path.size());
            }
            else{
                return Integer.MAX_VALUE; 
                
            }    
        }
        int min = Integer.MAX_VALUE;
        for(int i = index; i < intervals.length; i++ ){
            path.add(intervals[i]); 
            min = Math.min(min , backtrack(intervals, path , i +1));
            path.remove(intervals[i]);  
        }
        return min;
    }
    public boolean nonOverLap(List<int[]> intervals){
        if(intervals.size() == 0)
            return true; 

        for(int i = 1; i < intervals.size(); i++){
            int[] prev = intervals.get(i -1);  
            int[] cur = intervals.get(i);
            if(overlap(prev, cur))
                return false;
        }
        return true;
    }
    public boolean overlap(int[] interval1 , int[] interval2 ){
        if(interval1[1] > interval2[0])
            return true; 
        return false; 
    }

}


/* Notes: 

brute force way: 
at each interval: do I delete it or keep it and when we reach the end we check if in the path is overlapping or not 
and if yes: what should keep track of the min number (total size - path); 

O(2 ^ n) TC 
we will use index (I feel DP oin the problem)
with memo we can reduce TC: index dp[index] should be the min number of intervals removed to obtain non overlapping result from index index

sort intervals based on the start of each interval; 

dp[i] = if(overlaping with the next interval) = 1 + dp[i + 1]
if not overlapping it is dp[i] = dp[i +1]; 


however can we do better? 
*/