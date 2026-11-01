class Solution {
    public void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        int k = 0;
        int i = 0;
        while (k < nums.length) {
            while (freq[i] != 0) {
                nums[k] = i;
                freq[i]--;
                k++;
            }
            i++; 
        }
    }
}