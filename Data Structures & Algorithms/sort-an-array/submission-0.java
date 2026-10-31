class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0 , nums.length -1); 
        return nums; 

    }
    public void mergeSort(int[] nums, int start, int end){
        if(start == end ){
            return;
        }
        if(start == end - 1){
            if(nums[start] > nums[end])
                swap(nums, start, end);
            return; 
        }

        int mid = start + ((end - start) /2);  

        mergeSort(nums, start, mid ); 
        mergeSort(nums, mid +1, end); 

        merge(nums, start ,mid, end); 
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = temp; 
    }

     public void merge(int[] nums, int start, int mid, int end) {
        int[] result = new int[end - start + 1];
        int i = 0;
        int index1 = start;
        int index2 = mid + 1;

        while (index1 <= mid && index2 <= end) {
            if (nums[index1] <= nums[index2]) {
                result[i++] = nums[index1++];
            } else {
                result[i++] = nums[index2++];
            }
        }

        while (index1 <= mid) {
            result[i++] = nums[index1++];
        }

        while (index2 <= end) {
            result[i++] = nums[index2++];
        }

        for (int j = 0; j < result.length; j++) {
            nums[start + j] = result[j];
        }
    }
}

/*Notes: 


*/ 