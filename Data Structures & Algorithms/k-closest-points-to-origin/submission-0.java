class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> {
                int distanceA = a[0] * a[0] + a[1] * a[1];
                int distanceB = b[0] * b[0] + b[1] * b[1];
                return distanceA - distanceB; 
            }
        );
        for(int[] point: points){
            pq.add(point); 
        }
        int[][] result = new int[k][2];
        for(int i =0; i < k; i++){
            int[] point = pq.poll(); 
            result[i][0] = point[0];
            result[i][1] = point[1];
        }

        return result;
    }
}
