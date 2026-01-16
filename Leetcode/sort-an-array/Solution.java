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

// Heap sort
class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        for(int i = (n / 2) - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        for(int i = n - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            heapify(nums, 0, i);
        }

        return nums;
    }

    void heapify(int[] nums, int i, int end) {
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        if(left < end && nums[left] > nums[largest]) {
            largest = left;
        }

        if(right < end && nums[right] > nums[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            heapify(nums, largest, end);
        }
    }
}
