class Solution {

    public String encode(List<String> strs) {

        StringBuilder encoded = new StringBuilder();

        for (String str : strs) {
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }

        return encoded.toString();
    }

    public List<String> decode(String encoded) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < encoded.length()) {

            int j = i;

            // Find the '#'
            while (encoded.charAt(j) != '#') {
                j++;
            }

            // Get the length
            int length = Integer.parseInt(
                encoded.substring(i, j)
            );

            // Move past '#'
            j++;

            // Read 'length' characters
            String str = encoded.substring(j, j + length);

            result.add(str);

            // Move to the next encoded string
            i = j + length;
        }

        return result;
    }
}