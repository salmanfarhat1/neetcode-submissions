class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;

        for (int i = 0; i < 32; i++) {
            int bitA = (a >>> i) & 1;
            int bitB = (b >>> i) & 1;

            int bitSum = bitA ^ bitB ^ carry;
            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);

            sum = sum | (bitSum << i);
        }

        return sum;
    }
}