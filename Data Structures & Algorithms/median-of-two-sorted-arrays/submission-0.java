class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search on the smaller array
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        int totalLeft = (m + n + 1) / 2;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = totalLeft - mid1;

            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            int r1 = (mid1 == m) ? Integer.MAX_VALUE : nums1[mid1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            int r2 = (mid2 == n) ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                // Correct partition found
                if ((m + n) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);
            } 
            else if (l1 > r2) {
                // Too many elements from nums1 → move left
                high = mid1 - 1;
            } 
            else {
                // Too few elements from nums1 → move right
                low = mid1 + 1;
            }
        }

        return 0.0; // Should never reach here
    }
}
