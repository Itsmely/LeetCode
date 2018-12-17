package leetcode;

/**
 * 题目：最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        int index = 0;
        for(int i=0; i< strs[0].length(); i++){
            char c = strs[0].charAt(index);
            for(String str : strs){
                //当str的长度等于str【0】的长度 或 c的值不等于str的值时，直接返回str的0-index的字符串
                if(str.length() == i || c != str.charAt(index)){
                    return str.substring(0,index);
                }
            }
            index++;
        }
        return strs[0].substring(0,index);
    }
}
