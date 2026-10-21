/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() <= 1 )
            return true;
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (a,b) -> {
                return a.start - b.start; 
            }
        );
        for(int i = 0; i < intervals.size() ; i++)
            pq.offer(intervals.get(i)); 
        Interval prev = pq.poll();        
        while(!pq.isEmpty()){

            Interval cur = pq.poll();
            if(prev.end > cur.start)
                return false;
            prev = cur;
        } 
        return true;
    }
}
