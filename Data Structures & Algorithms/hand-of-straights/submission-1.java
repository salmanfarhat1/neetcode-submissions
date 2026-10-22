class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length; 
        int nbGroups = n / groupSize; 
        
        int[] freq = new int[nbGroups]; 
        int[] startG = new int[nbGroups]; 
        Arrays.fill(startG, -2);

        if(n % groupSize != 0)
            return false; 
    
        Arrays.sort(hand); 
        
        for(int i = 0; i < n; i++){
            int num = hand[i];
            for(int j = 0; j < nbGroups; j++){
                if(startG[j] == -2){
                    startG[j] = num; 
                    freq[j] = 1;
                    break;
                }
                else{
                    if(freq[j] < groupSize && startG[j] + freq[j] == num){
                        freq[j]++;
                        break; 
                    }
                }
            }
        }

        for(int i =  0; i < nbGroups; i++ ){
            if(freq[i] != groupSize)
                return false; 
        } 
        return true; 
    }
}

/* Notes: 
[1,2,4,2,3,5,3,4], groupSize = 4

group size = 8/4 = 2

[1,2,2,3,3,4,4,5]
-10

4, 4  
1, 2


if size mode group size ! = 0 return fasle
if I did not find a sequence of size 2 return false directly 

[1,2]
[2,3]
[3,4]
[4,5]

*/
