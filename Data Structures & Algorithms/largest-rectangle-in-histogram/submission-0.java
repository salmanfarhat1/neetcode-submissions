
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> h = new Stack<>();
        Stack<Integer> hIndex = new Stack<>();

        int max = 0;

        for (int i = 0; i < heights.length; i++) {

            int start = i;

            while (!h.isEmpty() && heights[i] < h.peek()) {

                int height = h.pop();
                int index = hIndex.pop();

                max = Math.max(max, height * (i - index));

                // This smaller height can also start
                // from the popped rectangle's starting index
                start = index;
            }

            h.push(heights[i]);
            hIndex.push(start);
        }

        // Anything remaining extends until the end
        while (!h.isEmpty()) {
            int height = h.pop();
            int index = hIndex.pop();

            max = Math.max(max, height * (heights.length - index));
        }

        return max;
    }
}