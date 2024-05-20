package org.sanpang.leetcode.hot;

import java.util.ArrayList;
import java.util.List;

public class LC131 {
    /*
    https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked
    给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串。返回 s 所有可能的分割方案。
    示例 1：
    输入：s = "aab"
    输出：[["a","a","b"],["aa","b"]]
    示例 2：
    输入：s = "a"
    输出：[["a"]]
    提示：
    */
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s).toString());
        //System.out.println(s.substring(0, 3));
    }
    public static List<List<String>> partition(String s) {
        List<List<String>> lists = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        solve(0, s, list, lists);
        return lists;
    }

    public static void solve(int curIndex, String s, List<String> list, List<List<String>> lists) {
        if ( curIndex == s.length() ) {
            List<String> res = new ArrayList<String>(list);
            lists.add(res);
            return;
        }

        for (int endIndex=curIndex+1; endIndex <= s.length(); endIndex++) {
            if ( valid(s.substring(curIndex, endIndex)) ) {
                list.add(s.substring(curIndex, endIndex));
                solve(endIndex, s, list, lists);
                list.remove(list.size()-1);
            }
        }

    }

    private static boolean valid(String substring) {
        int i = 0;
        int j = substring.length() - 1;
        while ( i < j ) {
            if(substring.charAt(i) != substring.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}
