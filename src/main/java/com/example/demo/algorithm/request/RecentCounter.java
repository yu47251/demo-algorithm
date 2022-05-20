package com.example.demo.algorithm.request;


import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 写一个RecentCounter类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 *
 * 
 * @author Eric Wang
 * @since 2022/5/6 11:37
 */
class RecentCounter {

    private List<Integer> list;

    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        return list.size() - getIndex(t);
    }

    public int getIndex(int t){
        int result = 0;
        for (int i=list.size()-2; i>=0; i--) {
            System.out.println(list.get(i) + "---" + i + "---" + (t-3000));
            if(list.get(i)>=t-3000) {
                result = i;
            }
        }
        System.out.println("-----");
        return result;
    }

    public static void main(String[] args) throws Exception {
        RecentCounter recentCounter = new RecentCounter();
        int a = recentCounter.ping(642);    // requests = [1]，范围是 [-2999,1]，返回 1
        int b = recentCounter.ping(1849);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
        int c = recentCounter.ping(4921);   // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
        int d = recentCounter.ping(5936);   // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
        int e = recentCounter.ping(5957);   // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
    }
}
