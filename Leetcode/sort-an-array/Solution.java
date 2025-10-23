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
