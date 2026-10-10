class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int max = 0;
        int maxFreq = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(c));

            // Characters we need to replace
            int count = (right - left + 1) - maxFreq;

            while (count > k) {
                char ch = s.charAt(left);

                map.put(ch, map.get(ch) - 1);

                left++;

                count = (right - left + 1) - maxFreq;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}