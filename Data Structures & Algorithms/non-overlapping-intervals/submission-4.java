
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int removed = 0; 
        int prevEnd = intervals[0][1];
        for(int i=1; i< intervals.length; i++){
            if(prevEnd > intervals[i][0]){
                removed++; 
                 prevEnd = Math.min(prevEnd, intervals[i][1]);
            }
            else{
                prevEnd = intervals[i][1];
            }
        }

        return removed;


    }
}