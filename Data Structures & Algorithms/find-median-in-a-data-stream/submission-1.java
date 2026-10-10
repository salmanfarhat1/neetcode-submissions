class MedianFinder {
    PriorityQueue<Integer> leftH;
    PriorityQueue<Integer> rightH;
    public MedianFinder() {
        leftH = new PriorityQueue<>(
            (a,b) -> {
                return b -a; 
            }
        ); 
        rightH = new PriorityQueue<>(); 
        
    }
    
    public void addNum(int num) {
        leftH.add(num);
        rightH.add(leftH.poll());
        if(rightH.size() > leftH.size())
            leftH.add(rightH.poll());

    }
    
    public double findMedian() {
        int size1 = leftH.size(); 
        int size2 = rightH.size(); 
        if(size1 == size2)
            return (((double)leftH.peek() + rightH.peek()) / 2); 
        else
            return (double) leftH.peek(); 
    }
}


/*Notes:
    maxheap min heap

 



-1 9 

size L > size R
    if(num > left.peek() )
        left.add()
        left.poll -> add it to the right 
    else{} 



    and the > 1 

*/