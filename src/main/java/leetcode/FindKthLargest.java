package leetcode;

/**
 * 题目：数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
class Solution4{
    public int findKthLargest(int[] nums, int k) {
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length-i-1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        int tmp = nums[nums.length-k];
        return tmp;
    }
}


public class FindKthLargest {
    public static void main(String[] args){
        Solution4 s = new Solution4();
        int[] nums = new int[]{2,3,1,4};
        System.out.println(s.findKthLargest(nums,2));
    }
}
