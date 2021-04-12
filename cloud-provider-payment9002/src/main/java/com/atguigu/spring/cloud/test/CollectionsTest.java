package com.atguigu.spring.cloud.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class CollectionsTest {
    public static void main(String[] args) throws InterruptedException {
//        List<Object> list = new ArrayList<>();
//        for (int i = 0; i <11 ; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        list.get(11);
//        Vector<Object> vector = new Vector<>();
//         vector.add(1);
//         vector.add(2);
//        System.out.println(vector);

        Vector<String> list = new Vector<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("t1-" + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    list.add("t2-" + i);
                }
            }
        });
        t1.start();
        t2.start();

        Thread.sleep(2000);
        int size = list.size();
        System.out.println("size = " + size);
        for (int i = 0; i < size; i++) {
            System.out.println("索引为" + i + "的元素为：" + list.get(i));
        }
    }



}
