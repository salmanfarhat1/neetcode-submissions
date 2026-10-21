class Solution {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;

        while (a != 0 || b != 0) {
            int bitA = a & 1;
            int bitB = b & 1;

            int bitSum = bitA ^ bitB ^ carry;
            carry = (bitA & bitB) | (bitA & carry) | (bitB & carry);

            sum = sum | (bitSum << 0); // current bit
            a >>>= 1;
            b >>>= 1;
        }

        return sum;
    }
}