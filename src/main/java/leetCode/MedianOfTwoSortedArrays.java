package leetCode;

import java.util.HashMap;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int aIndex = 0;
        int bIndex = 0;
        boolean isEven = (totalLength % 2) == 0;
        boolean isFirstComplete = nums1.length == 0;
        boolean isSecondComplete = nums2.length == 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= totalLength / 2; i++) {
            if (!isFirstComplete && !isSecondComplete) {
                if (nums1[aIndex] <= nums2[bIndex]) {
                    map.put(i, nums1[aIndex]);
                    aIndex++;
                    if (aIndex == nums1.length) {
                        isFirstComplete = true;
                    }
                } else {
                    map.put(i, nums2[bIndex]);
                    bIndex++;
                    if (bIndex == nums2.length) {
                        isSecondComplete = true;
                    }
                }
                continue;
            }

            if (isFirstComplete) {
                map.put(i, nums2[bIndex]);
                bIndex++;
                continue;
            }

            map.put(i, nums1[aIndex]);
            aIndex++;
        }

        if (isEven) {
            return ((double) (map.get(totalLength / 2) + map.get((totalLength / 2) - 1))) / 2;
        }

        return map.get(totalLength / 2);
    }
}
