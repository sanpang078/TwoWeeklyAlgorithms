package org.crc.hw.code;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 005 【按身高和体重排队】
 *
 * 按身高和体重排队
 * 某学校举行运动会，学生们按编号(1、2、3…n)进行标识，现需要按照身高由低到高排列，对身高相同的人，按体重由轻到重排列；对于身高体重都相同的人，维持原有的编号顺序关系。请输出排列后的学生编号。
 * 输入描述:
 * 两个序列，每个序列由n个正整数组成（0 < n <= 100）。第一个序列中的数值代表身高，第二个序列中的数值代表体重。
 * 输出描述:
 * 排列结果，每个数值都是原始序列中的学生编号，编号从1开始
 * 示例1：
 * 输入
 * 4
 * 100 100 120 130
 * 40 30 60 50
 * 输出
 * 2 1 3 4
 * 说明
 * 输出的第一个数字2表示此人原始编号为2，即身高为100，体重为30的这个人。由于他和编号为1的人身高一样，但体重更轻，因此要排在1前面。
 * 示例2：
 * 输入
 * 3
 * 90 110 90
 * 45 60 45
 * 输出
 * 1 3 2
 * 说明
 * 1和3的身高体重都相同，需要按照原有位置关系让1排在3前面，而不是3 1 2
 */
public class ZT05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入");
        int count = Integer.parseInt(sc.nextLine());
        String[] high = sc.nextLine().split(" ");
        String[] weight = sc.nextLine().split(" ");
        List<People> peopleList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            peopleList.add(new People(i+1,Integer.parseInt(high[i]),Integer.parseInt(weight[i])));
        }
        List<People> collect = peopleList.stream().sorted().collect(Collectors.toList());
        System.out.println("输出");
        collect.forEach(n -> System.out.print(n.getNum() + " "));
    }
}

class People implements Comparable<People>{
    private int num;
    private int height;
    private int weight;

    public People(int num, int height, int weight) {
        this.num = num;
        this.height = height;
        this.weight = weight;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    @Override
    public int compareTo(People people) {
        if(people.height > this.height){
            return -1;
        }
        if(people.height == this.height && people.weight > this.weight){
            return -1;
        }
        if (people.height == this.height && people.weight == this.weight && people.num > this.num){
            return -1;
        }
        return 1;
    }

    @Override
    public String toString() {
        return "People{" +
                "num=" + num +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
