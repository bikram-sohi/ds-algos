// class Solution {
//     class SpecialBST {
//         int value;
//         SpecialBST left;
//         SpecialBST right;
//         int leftSize = 0;

//         SpecialBST (int value) {
//             this.value = value;
//         }

//         int insert(int value, int count) {
//             if (this.value >= value) {
//                 this.leftSize++;
//                 if(left == null) {
//                     left = new SpecialBST(value);
//                     return count;
//                 }
//                 else {
//                     return left.insert(value, count);
//                 }
//             }
//             else {
//                 if(right == null) {
//                     right = new SpecialBST(value);
//                     return count + this.leftSize + 1;
//                 }
//                 else {                    
//                     return right.insert(value, count + this.leftSize + 1);
//                 }
//             }
//         }
//     }

//     public List<Integer> countSmaller(int[] nums) {
//         List<Integer> res = new ArrayList<>();
//         res.add(0, 0);
//         int l = nums.length - 1;
//         SpecialBST root = new SpecialBST(nums[l]);
//         for(int i = l - 1; i >= 0; i--) {
//             res.add(0, root.insert(nums[i], 0));
//         }
//         return res;
//     }
// }

class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        this.count = new int[n];
        int []indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        mergeSort(nums, indices, 0, n - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(count[i]);
        }
        return res;
    }

    public void mergeSort(int[] nums, int[] indices, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left)/2;
        mergeSort(nums, indices, left, mid);
        mergeSort(nums, indices, mid + 1, right);
        merge(nums, indices, left, mid, right);
    }
    public void merge(int[] nums, int[] indices, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightSmall = 0;

        while (i <= mid && j <= right) {
            if (nums[indices[i]] > nums[indices[j]]) {
                rightSmall++;
                temp[k++] = indices[j++];
            } else {
                count[indices[i]] += rightSmall;
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            count[indices[i]] += rightSmall;
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        System.arraycopy(temp, 0, indices, left, temp.length);
    }
}
