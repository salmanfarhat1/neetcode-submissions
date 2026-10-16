
class Solution {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        Queue<String> queue = new LinkedList<>();
        HashSet<String> words = new HashSet<>(wordList);

        if (!words.contains(endWord))
            return 0;

        queue.add(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord))
                    return length;

                for (String next : words) {
                    if (oneDiff(word, next)) {
                        queue.add(next);
                    }
                }

                words.remove(word);
            }

            length++;
        }

        return 0;
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
