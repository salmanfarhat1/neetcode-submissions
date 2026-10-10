class KthLargest {
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(
            (a,b) ->{ 
                return a - b;
            }
        ); 
        for(int i =0; i < nums.length; i++)
            pq.add(nums[i]);
        for(int i =0; i < nums.length - k ; i++)
            pq.poll(); 
    }
    public int add(int val) {
        pq.add(val);
        pq.poll(); 
        return pq.peek(); 
    }
}


/* notes:

x 1 5 10 

poll poll

*/ 