class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;

            int slow = i, fast = i;
            int direction = nums[i] > 0 ? 1 : -1;

            while (true) {
                slow = findNextIndex(nums, slow, direction);
                fast = findNextIndex(nums, fast, direction);
                if (fast != -1) {
                    fast = findNextIndex(nums, fast, direction);
                }

                if (slow == -1 || fast == -1) break;
                if (slow == fast) {
                    return true;
                }
            }

            int idx = i;
            while (nums[idx] * direction > 0) {
                int next = (idx + nums[idx]) % n;
                if (next < 0) next += n;
                nums[idx] = 0;
                idx = next;
            }
        }
        return false;
    }

    int findNextIndex(int[] nums, int currentIndex, int direction) {
        int n = nums.length;
        int nextIndex = (currentIndex + nums[currentIndex]) % n;
        if (nextIndex < 0) nextIndex += n;

        if (nextIndex == currentIndex || nums[nextIndex] * direction < 0) {
            return -1;
        }
        return nextIndex;
    }
}

