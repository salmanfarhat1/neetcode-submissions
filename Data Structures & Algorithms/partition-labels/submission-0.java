class Solution {
    public List<Integer> partitionLabels(String s) {
        Set<Character> set = new HashSet<>(); 
        int[] freq = new int[26];

        for(char ch: s.toCharArray())
            freq[ch - 'a']++; 

        List<Integer> result = new ArrayList<>(); 
        String cur = "";
        for(char ch : s.toCharArray() ){

            freq[ch -'a']--; 
            cur = cur + ch;
            if(freq[ch -'a'] == 0)
                set.remove(ch); 
            else
                set.add(ch);

            if(set.isEmpty()){
                result.add(cur.length()); 
                cur = ""; 
            }
        }

        return result; 

    }
}

/* Notes: 
x -> 3 
... 
to make sure that all the frequences of the other letters appeared is also 0 

Letter	Frequency
x	3 | 2 | 1 | 0 
y	2 | 1 | 0
b	4
z	2
i	1
s	1
l	1

26 
set{}
x y x x y  s1 -> s1.lengt
z ... 
    
*/ 
