package org.sanpang.hw.code;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ZT05 {

    public static void main(String[] args) {

        //接收三行输入参数 n，身高序列，体重序列
        //将身高、体重分别处理成数组
        Scanner sc = new Scanner(System.in);
        int nums = Integer.parseInt(sc.nextLine());
        String[] hight = sc.nextLine().split(" ");
        String[] weight = sc.nextLine().split(" ");


        //定义学生类，循环创建学生实例，给序号、身高、体重赋值，放到arraylist中
        ArrayList<Student> students = new ArrayList<Student>(nums);
        for (int i=0; i<nums; i++) {
            int hightInt = Integer.parseInt(hight[i]);
            int weightInt = Integer.parseInt(weight[i]);
            students.add(new Student(i, hightInt, weightInt));
        }

        //学生类实现comparable接口，身高从低到高，体重从轻到重，编号从小到大

        //对arraylist进行排序后，输出字符串
        Collections.sort(students);
        for (int i = 0; i < nums; i++) {
            System.out.println("学生编号：" + students.get(i).idx + " 身高：" + students.get(i).hight + "体重：" + students.get(i).weight);
        }


    }

    //普通内部类隐式包含了一个外部类的引用，即创建内部类必须先创建其外部类；static静态内部类则不包含，相当于一个普通的外部类，这里的实现之所以用内部类是因为内部类的私有属性才可以被其外部类直接访问，比如students.get(i).idx
    static class Student implements Comparable<Student>{
        private int idx;
        private int hight;
        private int weight;

        public Student(int idx, int hight, int weight) {
            this.idx = idx;
            this.hight = hight;
            this.weight = weight;
        }
        @Override  //重写compareTo(Student o)方法在implements中指定泛型Comparable<Student>
        public int compareTo(Student o) {
            if (this.hight < o.hight) {
                return -1;
            } else if (this.hight > o.hight) {
                return 1;
            }

            if (this.weight < o.weight){
                return -1;
            } else if (this.weight > o.weight) {
                return 1;
            }

            if (this.idx < o.idx) {
                return -1;
            } else if (this.idx > o.idx) {
                return 1;
            }

            return 0;
        }


    }

}


