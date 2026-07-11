/**
 * // This is MountainArray's API interface.
 * // You should not implement it or speculate about its implementation.
 * interface MountainArray {
 *     public int get(int index);
 *     public int length();
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = findPeak(mountainArr, n);

        // Search the increasing section first to get minimum index.
        int index = binarySearchIncreasing(
            mountainArr,
            target,
            0,
            peak
        );

        if (index != -1) {
            return index;
        }

        // Search the decreasing section.
        return binarySearchDecreasing(
            mountainArr,
            target,
            peak + 1,
            n-1);
    }

    private int findPeak(MountainArray mountainArr, int n) {
        int low = 0;
        int high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            int current = mountainArr.get(mid);
            int next = mountainArr.get(mid + 1);

            if (current < next) {
                // We are on the increasing slope.
                low = mid + 1;
            } else {
                // We are on the decreasing slope or at the peak.
                high = mid;
            }
        }

        return low;
    }

    private int binarySearchIncreasing(
        MountainArray mountainArr,
        int target,
        int low,
        int high
    ) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            if (value < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDecreasing(
        MountainArray mountainArr,
        int target,
        int low,
        int high
    ) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = mountainArr.get(mid);

            if (value == target) {
                return mid;
            }

            // Order is reversed in the decreasing portion.
            if (value < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}