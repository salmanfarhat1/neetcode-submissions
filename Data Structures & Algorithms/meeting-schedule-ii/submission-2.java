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

        PriorityQueue<Integer> ends = new PriorityQueue<>(
            (a, b) -> {
                    return a - b;
            }
        ); 

        for(int i = 0; i < intervals.size(); i++)
            pq.offer(intervals.get(i));

        int end  = pq.poll().end; 
        ends.offer(end); 
        int rooms = 1;

        while(!pq.isEmpty()){
            Interval next = pq.poll(); 
            if(ends.peek() <= next.start){
                ends.poll(); 
                
            }
            else{
                rooms++; 
            }
            ends.offer(next.end); 
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

[(25,579),(218,918), (623,1320), (685,1353),(1281,1307),(1308,1358)]

1
2

 918 1320  

*/ 