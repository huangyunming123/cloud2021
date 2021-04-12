package com.atguigu.cloud.test;

import java.util.concurrent.Callable;

public class ThreadTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+" :"+i);
            Thread.sleep(50);
        }
        return "success";
    }
}
