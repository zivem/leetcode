package com.zl.tree.bfs;

import java.util.*;

/**
 * @link https://leetcode-cn.com/problems/open-the-lock/
 * @date 2022.03.31
 */
public class OpenLock_752 {

    public static void main(String[] args) {
        String[] deadends = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        System.out.println(openLock(deadends, target));
    }

    public static int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        //需要跳过的
        List<String> deadLine = Arrays.asList(deadends);
        //已经过的
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int minStep = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            //
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deadLine.contains(cur)) {
                    //该字符串跳过
                    continue;
                }
                if (target.equals(cur)) {
                    return minStep;
                }

                for (int j = 0; j < 4; j++) {
                    String add = addOne(cur, j);
                    if (!visited.contains(add)) {
                        queue.offer(add);
                        visited.add(add);
                    }

                    String down = downOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }

            }
            minStep++;
        }
        return -1;

    }

    public static String addOne(String s, int i) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        if ('9' == c) {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    public static String downOne(String s, int i) {
        char[] chars = s.toCharArray();
        char c = chars[i];
        if ('0' == c) {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}
