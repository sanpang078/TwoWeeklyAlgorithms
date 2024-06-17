package org.crc.hw.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 007 【报数游戏】
 * 100个人围成一圈，每个人有一个编码，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
 * 输入描述:
 * 输入一个整数参数M
 * 输出描述:
 * 如果输入参数M小于等于1或者大于等于100，输出“ERROR!”；否则按照原先的编号从小到大的顺序，以英文逗号分割输出编号字符串
 * 示例1：
 * 输入
 * 3
 * 输出
 * 58,91
 * 说明
 * 输入M为3，最后剩下两个人
 * 示例2：
 * 输入
 * 4
 * 输出
 * 34,45,97
 * 说明
 * 输入M为4，最后剩下三个人
 */
public class ZT07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个整数参数M");
        int m = Integer.parseInt(sc.nextLine());
        //约瑟夫问题：用单向环形链表
        System.out.println("输出");
        playGame(100, m);
    }

    public static void playGame(int count, int m){
        if(m <= 1 || m >= 100){
            System.out.println("ERROR!");
            return;
        }
        SingleLinkedList game = new SingleLinkedList();
        game.createGame(count);

        //需要辅助节点，指向链表的最后一个位置
        Human temp = game.getFirst();
        int num = 100;
        while (temp.getNextHuman() != game.getFirst()) {
            temp = temp.getNextHuman();
        }
        //第二个辅助节点：指向当前位置
        Human cur = game.getFirst();
        while (true){
            if(num < m){
                //剩余的人数小于M
                game.show(cur);
                break;
            }
            for (int i = 1; i < m; i++) {
                cur = cur.getNextHuman();
                temp = temp.getNextHuman();
            }
            //取数
            cur = cur.getNextHuman();
            temp.setNextHuman(cur);
            num--;
        }
        System.out.println();
    }
}

class SingleLinkedList{
    private Human first;

    public Human getFirst() {
        return first;
    }

    public void createGame(int count){
        if(count < 1){
            System.out.println("ERROR!");
            return;
        }
        //辅助变量
        Human cur = null;
        for (int i = 0; i < count; i++) {
            Human temp = new Human(i + 1, null);
            if(i == 0){
                this.first = temp;
                this.first.setNextHuman(first);
                cur = this.first;
            }else {
                cur.setNextHuman(temp);
                temp.setNextHuman(first);
                cur = temp;
            }
        }
    }

    public void show(Human first){
        Human cur = first;
        List<Integer> result = new ArrayList<>();
        while (true){
            if(cur.getNextHuman().getCode() == first.getCode()){
                result.add(cur.getCode());
                result.stream().sorted().forEach(n -> System.out.printf(n + " "));
                break;
            }
            result.add(cur.getCode());
            cur = cur.getNextHuman();
        }
    }

    public int countHuman(){
        if(first == null){
            return 0;
        }
        int count = 1;
        Human temp = first.getNextHuman();
        while (temp != null && temp.getNextHuman() != first) {
            count++;
            temp = temp.getNextHuman();
        }
        return count + 1;
    }
}

class Human{
    private int code;
    private Human nextHuman;

    public Human(int code, Human nextHuman) {
        this.code = code;
        this.nextHuman = nextHuman;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Human getNextHuman() {
        return nextHuman;
    }

    public void setNextHuman(Human nextHuman) {
        this.nextHuman = nextHuman;
    }

    @Override
    public String toString() {
        return "Human{" +
                "code=" + code +
                ", nextHuman=" + nextHuman +
                '}';
    }
}
