class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int m = A.length;
        int n = B.length;
        int left = 0, right = m;
        int halfLen = (m + n + 1) / 2;

        while (left <= right) {
            int i = (left + right) / 2;
            int j = halfLen - i;

            int AL = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int AR = (i == m) ? Integer.MAX_VALUE : A[i];
            int BL = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int BR = (j == n) ? Integer.MAX_VALUE : B[j];

            if (AL <= BR && BL <= AR) {
                if ((m + n) % 2 != 0) {
                    return (double) Math.max(AL, BL);
                }
                return (Math.max(AL, BL) + Math.min(AR, BR)) / 2.0;
            } 
            else if (AL > BR) {
                right = i - 1;
            } 
            else {
                left = i + 1;
            }
        }
        return 0.0;
    }
}
