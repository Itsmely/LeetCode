package leetcode;

/**
 *题目：寻找两个有序数组的中位数
 *
 *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */

class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums[] = new int[nums1.length + nums2.length];
        for(int i=0; i<nums.length;i++){
            if(i< nums1.length){
                nums[i] = nums1[i];
            } else {
                nums[i] = nums2[i-nums1.length];
            }
        }

        for(int x=0; x<nums.length-1; x++){
            for(int y=0; y<nums.length-1-x;y++){
                if (nums[y] > nums[y+1] ){
                    int tmp = nums[y];
                    nums[y] = nums[y+1];
                    nums[y+1] = tmp;
                }
            }
        }

        //System.out.println(Arrays.toString(nums));

        if(nums.length %2 == 0){
            int center = (nums.length)/2;
            double x = ((double) nums[center-1] + (double)nums[center])/2;
            return x;
        } else {
            int center = (nums.length)/2;
            double y = nums[center];
            return y;
        }
    }
}

public class FindMedianSortedArrays {
    public static void main (String[] args){
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findMedianSortedArrays(new int[]{1, 2}, new int[]{-1,3}));
    }
}
