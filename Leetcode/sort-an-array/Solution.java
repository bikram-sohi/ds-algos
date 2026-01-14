// Bubble sort
class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = nums.length; i > 0; i--) {
            Boolean flip = false;
            for(int j = 1; j < i; j++) {
                if(nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    flip = true;
                }
            }
            if(flip == false) {
                break;
            }
        }
        return nums;
    }
}

// Selection sort
class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int min = i;
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
        return nums;
    }
}

// Insertion sort
class Solution {
    public int[] sortArray(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            for(int j = i; j > 0; j--) {
                if(nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
        return nums;        
    }
}

// Quick sort
class Solution {
    public int[] sortArray(int[] nums) {
        quick(nums, 0, nums.length - 1);
        return nums;        
    }

    void quick(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int p = start;
        int left = start + 1;
        int right = end;

        while(left <= right) {
            if(nums[left] > nums[p] && nums[right] < nums[p]) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
            if(nums[left] <= nums[p]) {
                left++;
            }
            if(nums[right] >= nums[p]) {
                right--;
            }
        }

        int temp = nums[p];
        nums[p] = nums[right];
        nums[right] = temp;
        
        quick(nums, start, right - 1);
        quick(nums, right + 1, end);
    }
}
