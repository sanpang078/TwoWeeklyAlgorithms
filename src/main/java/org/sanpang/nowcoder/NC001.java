package org.sanpang.nowcoder;

/*题目：
现在信用卡开展营销活动，持有我行信用卡客户推荐新户办卡，开卡成功后可获得积分奖励。规定每个客户最多可推荐两个新户且一个新户只能被推荐一次。
但允许链接效应，即若客户A推荐了新户B，新户B推荐新户C，则客户C同时属于A和B的推荐列表。
简单起见，只考虑以一个老客户A作起点推荐的情况。编程计算推荐新户数不小于n的客户列表。

输入示例：
5 2
A B C
C F *
B D E
D G *
E H I

输入描述：
输入的第一行为以空格分隔的两个正整数，第一个表示原始推荐列表的个数m，第二个表示n的取值。
其后m行每行均为一个以空格分隔的原始推荐列表，第一列为推荐人，后面两列为被推荐人，若该推荐人只推荐了一个新户，则第三列以*替代。推荐人和被推荐人均以大写字母表示，不同字母代表不同的人。

输出示例：
A B E

输出描述：
即在同一行输出符合条件的客户列表，无顺序要求，客户间以空格分隔。若客户列表为空，则输出None。

*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NC001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mnStr = sc.nextLine();
        String[] mn = mnStr.split("\\s");
        Integer m = Integer.valueOf(mn[0]);
        Integer n = Integer.valueOf(mn[1]);
        Map<String, ListNode> map = new HashMap<>();
        ListNode root = null;
        for (int i = 0; i < m; i++) {
            String line = sc.nextLine();
            String[] s = line.split("\\s");
            String key = s[0];
            String leftKey = s[1];
            String rightKey = s[2];
            ListNode node = map.getOrDefault(key, null);
            if ( node == null ) {
                node = new ListNode(key);
                map.put(key, node);
            }
            if ( i == 0 ) root = node;

            if (!leftKey.equals("*")) {
                ListNode left = new ListNode(leftKey);
                map.put(leftKey, left);
                node.left = left;
            }
            if (!rightKey.equals("*")) {
                ListNode right = new ListNode(rightKey);
                map.put(rightKey, right);
                node.right = right;
            }
        }

        Map<ListNode, Integer> res = new HashMap<>();
        putNodeSubCount(root, res);

        for (Map.Entry<ListNode, Integer> entry:res.entrySet()) {
            if ( entry.getValue() >= n ) System.out.println(entry.getKey().val);
            //System.out.println(entry.getKey().val + ": " + entry.getValue());
        }

        //preorderTraversal(root);
    }

    public static void putNodeSubCount(ListNode node, Map<ListNode, Integer> res){
        if (node == null) {
            return ;
        }
        int count = 0;
        if (node.left != null) count +=1;
        putNodeSubCount(node.left, res);
        count += res.getOrDefault(node.left, 0);

        if (node.right != null) count +=1;
        putNodeSubCount(node.right, res);
        count += res.getOrDefault(node.right, 0);

        res.put(node, count);
    }


    public static void preorderTraversal(ListNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
    }
}

class ListNode {
    String val;
    ListNode left;
    ListNode right;

    public ListNode(String val) {
        this.val = val;
    }
    public ListNode(String val, ListNode left) {
        this.val = val;
        this.left = left;
    }
    public ListNode(String val, ListNode left, ListNode Right) {
        this.val = val;
        this.left = left;
        this.right = Right.right;
    }
}
