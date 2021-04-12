package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.test.ThreadTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RestController
@Slf4j
public class testController {
    int a = 0;
    @RequestMapping("/test1")
    public String test1(){
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(++a);
        long id = Thread.currentThread().getId();
        return id+"";
    }

    @RequestMapping("/test2")
    public String test2(){
        long id = Thread.currentThread().getId();
        System.out.println(id);
        return id+"";
    }

    @SentinelResource(value = "test3",blockHandler = "deal_test3")
    @RequestMapping("/test3")
    public String test3(@RequestParam(required = false,value = "t1") String t1,@RequestParam(required = false,value = "t2") String t2){
        long id = Thread.currentThread().getId();
        int a = 10/0;
        System.out.println(id);
        return id+"";
    }

    public String deal_test3(String t1,String t2, BlockException exception){
        return "┭┮﹏┭┮";
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> stringFutureTask = new FutureTask<String>(new ThreadTest());
        Thread ddd = new Thread(stringFutureTask, "ddd");
        ddd.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+" :"+i);
        }
        String s = stringFutureTask.get();
        System.out.println(s);
    }
}
