package leetcode;

/**
 *题目：三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();//创建一个haseset，可以过滤重复list
        Arrays.sort(nums);//对nums进行排序

        for(int i=0; i<nums.length; i++){
            int mid = i+1;
            int right = nums.length-1;
            int left = i;
            while(mid < right){
                if(nums[left] + nums[mid] + nums[right] == 0){
                    List list = new ArrayList();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    result.add(list);
                    while(mid < left && nums[mid] == nums[mid+1]){
                        mid++;
                    }
                    while(mid < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    mid++;
                    right--;

                }else if(nums[left] + nums[mid] + nums[right] < 0){
                    mid++;
                }else{
                    right--;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
}
