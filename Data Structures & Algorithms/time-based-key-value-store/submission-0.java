class TimeMap {
    HashMap<String, List<Integer>> mapTime; 
    HashMap<String, List<String>> mapString; 
    public TimeMap() {
        mapTime = new HashMap();  
        mapString = new HashMap();  
    }
    
    public void set(String key, String value, int timestamp) {
        List<Integer> listInt = mapTime.getOrDefault(key, new ArrayList<>());
        List<String> listString = mapString.getOrDefault(key, new ArrayList<>());
        listInt.add(timestamp);
        listString.add(value); 
        mapTime.put(key, listInt);
        mapString.put(key, listString);  
    }
    
    public String get(String key, int timestamp) {
        List<Integer> listInt = mapTime.getOrDefault(key, new ArrayList<>()); 
        List<String> listString = mapString.getOrDefault(key, new ArrayList<>()); 

        if(listInt.size() == 0 )
            return ""; 

        int left = 0;
        int right =  listInt.size() -1; 
        while(left <= right){
            int mid = left + (right  - left ) /2; 
            if(listInt.get(mid) == timestamp)
                return listString.get(mid);
            else if(listInt.get(mid) < timestamp)
                left = mid + 1;
            else
                right  = mid -1;  
        }
        if(right < 0)
            return ""; 
        return listString.get(right);
    }
}


/*Notes: 

key name -> (hashMap  timestamp -> value)
pq for alice [1 -> happy] [3-> sad]
[1 , 2, 5, 10]
[happy, sad , happy , sad, happy] 
search is O(log n)
sorting: 


*/
