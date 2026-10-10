class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i= 0; i < nums.length; i++){
            int counter = map.getOrDefault(nums[i], 0);
            counter++; 
            map.put(nums[i], counter); 
        } 

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                return map.get(b) - map.get(a);
            }
        ); 
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry.getKey());
        } 

        int[] res = new int[k];
        for(int i =0; i < k; i++){
            res[i] = pq.poll();
        }
        return res; 
    }
}