class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        HashMap<Integer, Double> map = new HashMap<>(); 
        for(int i =0; i < position.length; i++)
            map.put(position[i], (double)(target - position[i])/ speed[i]);
        Arrays.sort(position);     

        double track = map.get(position[position.length -1]); 
        int counter = 1;
        for(int i = position.length -1; i >= 0 ; i--){
            double reachedTime = map.get(position[i]); 
            if(reachedTime <= track)
                continue;
            track = reachedTime; 
            counter++; 
        }

        return counter;



    }
}
