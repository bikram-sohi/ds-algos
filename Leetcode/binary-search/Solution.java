// class Solution {
//     public int search(int[] nums, int target) {
//         return helper(nums, target, 0, nums.length - 1);
//     }
//     int helper(int[] nums, int target, int left, int right) {
//         if(left > right) {
//             return -1;
//         }
//         int mid = (right + left) / 2;
//         if(nums[mid] > target) {
//             return helper(nums, target, left, mid - 1);
//         } else if(nums[mid] < target) {
//             return helper(nums, target, mid + 1, right);
//         } else {
//             return mid;
//         }
//     }
// }

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (right + left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
