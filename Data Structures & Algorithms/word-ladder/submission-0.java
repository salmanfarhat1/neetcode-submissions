class Solution {
    int min = Integer.MAX_VALUE; 
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Boolean> visited = new HashMap(); 
        dfs(beginWord, endWord, wordList, visited, new ArrayList<>()); 
        return min == Integer.MAX_VALUE ? 0 : min; 
    }
    public void dfs(String beginWord, String endWord, List<String> wordList,
                    HashMap<String, Boolean> visited, List<String> path){
        if(beginWord.equals(endWord)){
            min = Math.min(min, path.size() + 1);
            return; 
        }

        boolean isVisited = visited.getOrDefault(beginWord, false);

        if(isVisited)
            return; 
        
        visited.put(beginWord, true ); 

        for(int i = 0; i < wordList.size(); i++){
            
            if(!oneDiff(wordList.get(i) , beginWord))
                continue; 

            path.add(wordList.get(i));
            dfs(wordList.get(i) , endWord, wordList, visited, path);
            path.remove(path.size() -1); 
        }
        visited.remove(beginWord);
    }
    public boolean oneDiff(String s1, String s2) {
        int counter = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                counter++;
        }

        return counter == 1;
    }
}


/* Notes: 
input: begin word - end word
output: the minimum number of transformation needed to reach endword from begin word

example:
Input: beginWord = "cat", endWord = "sag", wordList = ["bat","bag","sag","dag","dot"]
cat -> bat  -> bag -> sag


            -> dag  -> bag (visited)\
                    -> sag (result)
                    
brute force way is to detect all the paths and keep track of a minimum value

can we do better ? 
cat --  sag --> number of diff letters are: 2 
can I find cag or sat in the list ? 
I can cerate a trie to allow fast discovery of this using O( string size)


create trie -> make trie of the words in the list
then 
to transform cat to sag we want }
cat -> ... -> cag ... -> sag

I need to check all the possible outputs because what is it exist in 

cat dat dag cag need to exist for sure 
how to move to cag ? 



*/ 