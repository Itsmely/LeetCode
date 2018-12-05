package leetcode;

/**
 * 题目：最长回文子串
 *
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */

class Solution3 {
    public String longestPalindrome(String s) {
        String result = null;
        //存放最大回文字符串的长度
        int max = 0;
        //遍历每一个字符，以每一个字符为中心判断奇偶扩展子串
        for (int i = 0; i < s.length(); i++) {
            //定义两个数组下标指针，以i，i+1中心为中心的偶子序列
            int pStart = i;
            int pEnd = i + 1;
            while (pStart >= 0 && pEnd <= (s.length() - 1) && s.charAt(pStart) == s.charAt(pEnd)) {
                pStart--;
                pEnd++;
            }
            //如果字符串的长度>max，则暂存为最长回文串，子回文串的长度=(pEnd-1)-(pStart+1)-1=pEnd-pStart-1
            if(pEnd-pStart-1 > max){
                max = pEnd - pStart -1;
                result = s.substring(pStart+1,pEnd-1+1);
            }
            //以i为中心，判断扩展奇序列是否为回文串
            pStart=i-1;
            pEnd=i+1;
            while(pStart>=0 && pEnd<=(s.length()-1) && s.charAt(pStart)==s.charAt(pEnd)){
                pStart--;
                pEnd++;
            }
            if (pEnd-pStart-1>max) {
                max=pEnd-pStart-1;
                result=s.substring(pStart+1, pEnd-1+1);
            }
        }
        if(result == null){
            return "";
        } else{
            return result;
        }
    }
}


public class LongestPalindrome {
    public static void main (String[] args){
        String str = new String("google");
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.longestPalindrome(str));
    }
}
