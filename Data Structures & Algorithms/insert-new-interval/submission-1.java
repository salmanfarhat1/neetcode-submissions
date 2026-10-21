class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>(); 

        int i = 0;
        int n = intervals.length;
        while( i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]); 
            i++; 
        }

        while( i < n && intervals[i][1] >= newInterval[0]){
            int min = Math.min(intervals[i][0], newinterval[0]);
            i++; 
        }
        result.add(newInterval); 

        while(i < n){
            result.add(intervals[i]); 
            i++; 
        }
        int[][] res = new int[result.size()][2];
        for( i = 0; i < result.size(); i++ )
            res[i] = result.get(i); 
        return res;
    }
}


/* Notes: 
[[1,3],[4,6]], newInterval = 

holder[] = [2,5]



[[1,2],[3,5],[9,10]], newInterval = [2,4]


[
[1,5]
[9,10 ]
]

[1, 5]


*/