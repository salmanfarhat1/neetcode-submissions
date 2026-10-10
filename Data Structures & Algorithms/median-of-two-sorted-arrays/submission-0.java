class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int size = nums1.length + nums2.length;
        // numsB1 = smaller array
        int[] numsB1 = (nums1.length <= nums2.length) ? nums1 : nums2;
        int[] numsB2 = (nums1.length <= nums2.length) ? nums2 : nums1;
        int left = 0;
        int right = numsB1.length;
        int half = (size + 1) / 2;
        while (left <= right) {
            int partition = left + (right - left) / 2;
            int partition2 = half - partition;
            int left1 = (partition == 0)? Integer.MIN_VALUE: numsB1[partition - 1];
            int right1 = (partition == numsB1.length)? Integer.MAX_VALUE: numsB1[partition];
            int left2 = (partition2 == 0)? Integer.MIN_VALUE: numsB2[partition2 - 1];
            int right2 = (partition2 == numsB2.length) ? Integer.MAX_VALUE: numsB2[partition2];
            if (left1 <= right2 && left2 <= right1) {
                if (size % 2 == 1) {
                    return Math.max(left1, left2);
                }
                return (Math.max(left1, left2)
                        + Math.min(right1, right2)) / 2.0;
            }
            else if (left1 > right2) {
                right = partition - 1;
            }
            else {
                left = partition + 1;
            }
        }
        return 0;
    }
}