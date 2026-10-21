
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        int removed = 0; 
        int[] prevI = intervals[0];

        for(int i=1; i< intervals.length; i++){
            if(prevI[1] > intervals[i][0])
            {
                removed++; 
            }
            else{
                prevI = intervals[i]; 
            }
        }

        return removed;


    }
}