// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int len = nums.length;
//         int[] lengths = new int[len];

//         for(int i = 0; i < len; i++) {
//             lengths[i] = 1;
//         }

//         int max = 1;

//         for(int i = 1; i < len; i++) {
//             for(int j = 0; j < i; j++) {
//                 if(nums[j] < nums[i] && lengths[i] <= lengths[j] + 1) {
//                     lengths[i] = lengths[j] + 1;
//                     if(lengths[i] > max) {
//                         max = lengths[i];
//                     }
//                 }
//             }
//         }

//         return max;
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] indices = new int[len + 1];

        for(int i = 0; i <= len ; i++) {
            indices[i] = -1;
        }

        int max = 0;

        for(int i = 0; i < len; i++) {
            int idx = binarySearch(indices, nums, nums[i], 1, max);
            indices[idx] = i;
            max = Math.max(max, idx);
        }

        return max;
    }

    int binarySearch(int[] indices, int[] nums, int val, int start, int end) {
        if(start > end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums[indices[mid]] < val) {
            return binarySearch(indices, nums, val, mid + 1, end);
        }
        else {
            return binarySearch(indices, nums, val, start, mid - 1);
        }
    }
}
