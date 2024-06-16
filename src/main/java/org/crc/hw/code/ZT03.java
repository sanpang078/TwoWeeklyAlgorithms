package org.crc.hw.code;

import java.util.*;

/**
 * 003 【TLV解码】
 * TLV编码是按[Tag Length Value]格式进行编码的，一段码流中的信元用Tag标识，Tag在码流中唯一不重复，Length表示信元Value的长度，Value表示信元的值。
 * 码流以某信元的Tag开头，Tag固定占一个字节，Length固定占两个字节，字节序为小端序。
 * 现给定TLV格式编码的码流，以及需要解码的信元Tag，请输出该信元的Value。
 * 输入码流的16机制字符中，不包括小写字母，且要求输出的16进制字符串中也不要包含小写字母；码流字符串的最大长度不超过50000个字节。
 * 输入描述:
 * 输入的第一行为一个字符串，表示待解码信元的Tag；
 * 输入的第二行为一个字符串，表示待解码的16进制码流，字节之间用空格分隔。
 * 输出描述:
 * 输出一个字符串，表示待解码信元以16进制表示的Value。
 * 示例1：
 * 输入
 * 31
 * 32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC
 * 输出
 * 32 33
 * 说明
 * 需要解析的信元的Tag是31，从码流的起始处开始匹配，Tag为32的信元长度为1（01 00，小端序表示为1）；第二个信元的Tag是90，其长度为2；第三个信元的Tag是30，其长度为3；第四个信元的Tag是31，其长度为2（02 00），所以返回长度后面的两个字节即可，即32 33。
 *
 * 大小端序：
 *  MSB=高位字节=高字节=高位 ：影响力最大的BIT位
 *  LSB=低位字节=低字节=低位 ：影响最小的BIT位
 *  任何数据存储到地址内时，都遵照一个规则，从0x00低地址开始向大地址存储。
 *  大端序：先存高位
 *  小端序：先存低位。
 */

public class ZT03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入：");
        String targetTag = sc.nextLine();
        String source = sc.nextLine();
        String tlvValue = getTLVValue(targetTag, source);
        System.out.println("输出：\r\n" + tlvValue.toUpperCase());
    }

    public static String getTLVValue(String target, String source){
        String[] s = source.split(" ");
        //当前元素指针
        int index = 0;
        //用map存储每个待解析的信元以及value值
        Map<String, String> resultMap = new HashMap<>();
        while (index <= s.length - 1){
            //获取tag
            String key = s[index];
            //获取长度，并从小端序转为大端序
            String tempLength = s[index+2] + s[index+1];
            //去掉长度前面的0数字，并从16进制转为10进制
            tempLength = tempLength.replaceFirst("0+", "");
            int length = Integer.parseInt(tempLength, 16);
//            System.out.println("tag:" + key + " 的信元长度为：" + length);
            //根据长度拼接后面的value值
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(s[index + 3 + i]).append(" ");
            }
            //存储每个待解析的信元以及value值
            resultMap.put(key, sb.toString());
            //指针后移：
            index = index + 3 + length;
        }
        //获取需要解析的信元的value值
        return resultMap.get(target);
    }
}
