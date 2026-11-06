class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4)
            return false;
        int sum = 0; 
        for(int stick: matchsticks)
            sum += stick; 
        if(sum % 4 != 0 )
            return false;
                       
        Arrays.sort(matchsticks);
        int side = sum / 4;
        for(int i = 0; i < matchsticks.length; i++){
            if(!backtrack(matchsticks, side, new boolean[matchsticks.length]))
                return false;
        }
        return true; 
    }
    public boolean backtrack(int[] nums, int side, boolean[] visited){
        if(side == 0)
            return true; 
        
        if(side < 0)
            return false; 

        for(int i = 0; i < nums.length; i++){
            if(visited[i])
                continue; 
            visited[i] = true; 
            if(backtrack(nums , side - nums[i], visited))
                return true; 
            visited[i] = false; 
        } 

        return false;
        
    }
}

/* Notes: 
A square have al the sides equal 
16 / 4 -> 4 per side

case: 16 % 4 != 0 return false; 
[4, 4, 4, 4]
[1, 0 , 0 , 0]
[4, 4, 4, ]

[1,3,4,2,2,4] how many sides sum up to 4 ? 

visited[track]= [matchstick]
backtrack can accumelate the visited so i od ont use a visited one
1 on 
3
if sum = 4 return; 
visited = [T , T , false. fasle;... ]

[1,2,2,3,4,4]
1 3 

*/ 