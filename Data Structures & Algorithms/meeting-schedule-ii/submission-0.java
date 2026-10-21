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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() <= 1)
            return intervals.size(); 
        
        PriorityQueue<Interval> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.start == b.start)
                    return a.end - b.end; 
                else
                    return a.start - b.start;
            }
        ); 

        for(int i = 0; i < intervals.size(); i++)
            pq.offer(intervals.get(i));

        int end  = pq.poll().end; 
        int rooms = 0;

        while(!pq.isEmpty()){
            Interval next = pq.poll(); 
            if(end >  next.start){
                rooms++; 
                end = Math.max(end, next.end); 
            }
        }

        return rooms; 
    }
}


/* Notes:

[(0,40),(5,10),(15,20)]
0, 40


end < next[5]
end = 10
else
end = math.max(40) 


*/ 