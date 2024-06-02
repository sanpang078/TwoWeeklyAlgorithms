package org.sanpang.leetcode.hot;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20 {
    /*https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked
    20. 有效的括号
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    每个右括号都有一个对应的相同类型的左括号。
    示例 1：
    输入：s = "()"
    输出：true
    示例 2：
    输入：s = "()[]{}"
    输出：true
    示例 3：
    输入：s = "(]"
    输出：false
 */
    public static void main(String[] args) {


        //String s = "()[]{}";
        String s = "]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            Character cha = s.charAt(i);
            if ( map.containsKey(cha)) {
                stack.push(s.charAt(i));
            } else if (map.containsValue(cha)) {
                if ( stack.isEmpty() ) return false;
                Character top = stack.pop();
                if ( !map.get(top).equals(cha) ) return false;
            } else {
                return false;
            }
        }
        if ( !stack.isEmpty() ) return false;
        return true;
    }
}
