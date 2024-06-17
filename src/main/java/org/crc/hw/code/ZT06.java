package org.crc.hw.code;

import java.util.*;

/**
 * 006 【按索引范围翻转文章片段】
 * 输入一个英文文章片段，翻转指定区间的单词顺序，标点符号和普通字母一样处理。例如输入字符串"I am a developer. “，区间[0,3]，则输出"developer. a am I"
 * String reverseWords(String s, int start, int end)
 * 输入描述:
 * 使用换行隔开三个参数，第一个参数为英文文章内容即英文字符串，第二个参数为翻转起始单词下标(下标从0开始)，第三个参数为结束单词下标。
 * 输出描述:
 * 翻转后的英文文章片段所有单词之间以一个半角空格分隔进行输出
 * 示例1：
 * 输入
 * I am a developer.
 * 1
 * 2
 * 输出
 * I a am developer.
 * 示例2：
 * 输入
 * hello world!
 * 0
 * 1
 * 输出
 * world! hello
 * 说明
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例3：
 * 输入
 * I am a developer.
 * 0
 * 3
 * 输出
 * developer. a am I
 * 说明
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例4：
 * 输入
 * Hello!
 * 0
 * 3
 * 输出
 * EMPTY
 * 说明
 * 指定翻转区间只有一个单词或无有效单词，则统一输出"EMPTY"
 */
public class ZT06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入");
        String s = sc.nextLine();
        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());
        System.out.println("输出：");
        reverseWord(s, start, end);
    }

    public static void reverseWord(String words, int start, int end){
        String[] split = words.trim().split("\\s+");
        if(start < 0 || end <= start || end >= split.length){
            System.out.println("EMPTY");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start; i++) {
            sb.append(split[i]).append(" ");
        }
        for (int i = end; i >= start; i--) {
            sb.append(split[i]).append(" ");
        }
        for (int i = end + 1; i < split.length; i++) {
            sb.append(split[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
