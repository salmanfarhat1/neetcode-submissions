class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        for(int i = 0; i < triplets.length; i++){
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2] ){
                triplets[i][0] = -1; 
                triplets[i][1] = -1; 
                triplets[i][2] = -1; 
            }
        }
        int[] result = triplets[0]; 
        for(int i = 1; i < triplets.length; i++){
            result[0] = Math.max(result[0], triplets[i][0]); 
            result[1] = Math.max(result[1], triplets[i][1]); 
            result[2] = Math.max(result[2], triplets[i][2]); 
        }
        return (result[0] == target[0]) && (result[1] == target[1]) && (result[2] == target[2]) ;
    }
}


