package com.example.demo.algorithm.consistent;

import java.util.stream.IntStream;

public class Main {
    private static final String PRE_KEY = "";
    private static final int DATA_VALUE = 5000000;

    public static void main(String[] args) {
        Cluster cluster = new ConsistencyHashCluster();
        cluster.addNode(new Node("abc","192.168.0.1"));
        cluster.addNode(new Node("bcd","192.168.0.2"));
        cluster.addNode(new Node("cde","192.168.0.3"));
        cluster.addNode(new Node("def","192.168.0.4"));


        IntStream.range(0, DATA_VALUE).forEach(
                index -> {
                    Node node = cluster.get(PRE_KEY + index);
                    node.put(PRE_KEY + index, "Main Data");
                }
        );

        System.out.println("数据分布情况：");
        cluster.nodes.forEach(node -> {
            System.out.println("IP:" + node.getIp() + ",数据量:" + node.getData().size());
        });


        // 增加一个节点
        cluster.addNode(new Node("efg","192.168.0.5"));

        //缓存命中率
        long hitCount = IntStream.range(0, DATA_VALUE)
                .filter(index -> cluster.get(PRE_KEY + index).get(PRE_KEY + index) != null)
                .count();
        System.out.println("缓存命中率：" + hitCount * 1f / DATA_VALUE);
    }
}
