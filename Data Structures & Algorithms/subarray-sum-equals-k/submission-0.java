class Solution {
    public int subarraySum(int[] nums, int k) {
        // [2 -1 1 2]
        // prefix sum = [2 1 2 4]
        //  do we have zero --> yes ---- add 2 
        //  1 - 2 = -1 ? no ---- add -1
        //  2 ----- yes add 2 
        //  4 - 2 --- 2 yes 2 times
        // cur prefix - x = 2 searching for x
        // x = curPredix - 2 

        // if map contains x then counter++ 
        // add curPrefix to map 

        // [4 8 12 16 20 2 4]
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        map.put(0,1); 
        int[] prefix = new int[n]; 
        prefix[0] = nums[0]; 

        for(int i = 1; i < n; i++){    
            prefix[i] = prefix[i -1] + nums[i];
        }
        int counter = 0;
        for(int i = 0; i < n; i++){
            int freq = map.getOrDefault((prefix[i] - k), 0); 
            if(freq > 0){
                counter += freq;
            } 
            map.put(prefix[i], map.getOrDefault(prefix[i] , 0) + 1);
        }

        return counter;
    }
}