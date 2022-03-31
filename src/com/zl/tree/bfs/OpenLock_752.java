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

    static String t, s;
    static Set<String> set = new HashSet<>();
    public static int openLock2(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        t = target;
        s ="0000";
        //需要跳过的
        set = new HashSet<>(Arrays.asList(deadends));
       return bfs();

    }

    static int bfs() {
        // d1 代表从起点 s 开始搜索（正向）
        // d2 代表从结尾 t 开始搜索（反向）
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();
        /*
         * m1 和 m2 分别记录两个方向出现的状态是经过多少次转换而来
         * e.g.
         * m1 = {"1000":1} 代表 "1000" 由 s="0000" 旋转 1 次而来
         * m2 = {"9999":3} 代表 "9999" 由 t="9996" 旋转 3 次而来
         */
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.addLast(s);
        m1.put(s, 0);
        d2.addLast(t);
        m2.put(t, 0);

        /*
         * 只有两个队列都不空，才有必要继续往下搜索
         * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，如果 d1 为空了，说明从 s 搜索到底都搜索不到 t，反向搜索也没必要进行了
         */
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            if (d1.size() <= d2.size()) {
                t = update(d1, m1, m2);
            } else {
                t = update(d2, m2, m1);
            }
            if (t != -1) return t;
        }
        return -1;
    }
    static int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = deque.size();
        while (m-- > 0) {
            String poll = deque.pollFirst();
            char[] pcs = poll.toCharArray();
            int step = cur.get(poll);
            // 枚举替换哪个字符
            for (int i = 0; i < 4; i++) {
                // 能「正向转」也能「反向转」，这里直接枚举偏移量 [-1,1] 然后跳过 0
                for (int j = -1; j <= 1; j++) {
                    if (j == 0) continue;

                    // 求得替换字符串 str
                    int origin = pcs[i] - '0';
                    int next = (origin + j) % 10;
                    if (next == -1) next = 9;

                    char[] clone = pcs.clone();
                    clone[i] = (char)(next + '0');
                    String str = String.valueOf(clone);

                    if (set.contains(str)) continue;
                    if (cur.containsKey(str)) continue;

                    // 如果在「另一方向」找到过，说明找到了最短路，否则加入队列
                    if (other.containsKey(str)) {
                        return step + 1 + other.get(str);
                    } else {
                        deque.addLast(str);
                        cur.put(str, step + 1);
                    }
                }
            }
        }
        return -1;
    }


}
